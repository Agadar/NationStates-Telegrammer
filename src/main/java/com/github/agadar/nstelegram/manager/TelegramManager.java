package com.github.agadar.nstelegram.manager;

import com.github.agadar.nstelegram.enums.TelegramType;
import com.github.agadar.nsapi.NSAPI;
import com.github.agadar.nstelegram.event.RecipientRemovedEvent;
import com.github.agadar.nstelegram.event.RecipientRemovedEvent.Reason;
import com.github.agadar.nstelegram.event.TelegramManagerListener;
import com.github.agadar.nstelegram.filter.abstractfilter.Filter;
import com.github.agadar.nstelegram.runnable.SendTelegramsRunnable;
import com.github.agadar.nstelegram.util.Tuple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Manages the recipients list and sending telegrams to the former.
 * 
 * @author Agadar <https://github.com/Agadar/>
 */
public final class TelegramManager
{
    // User agent string for formatting.
    private final static String USER_AGENT = "Agadar's Telegrammer using Client "
            + "Key '%s' (https://github.com/Agadar/NationStates-Telegrammer)";
    // Duration in milliseconds for timeout when no recipients were found while looping.
    private final static int NO_ADDRESSEES_FOUND_TIMEOUT = 60000;
    
    private final List<Filter> Filters = new ArrayList<>(); // The filters to apply in chronological order.
    private final Set<String> Recipients = new HashSet<>(); // Presumably most up-to-date recipients list, based on Filters.
    private final Map<Tuple<String, String>, Reason> History = new HashMap<>();   // History of recipients, mapped to telegram id's.
    private final Set<TelegramManagerListener> Listeners = new HashSet<>(); // Listeners to events thrown by this.
    private Thread TelegramThread; // The thread on which the TelegramQuery is running.
    
    // Variables that will be used for sending the telegrams. Should be manually
    // updated by a form or where-ever these values are defined.
    public String ClientKey;
    public String TelegramId;
    public String SecretKey;
    public TelegramType LastTelegramType;
    public String FromRegion;
    public boolean IsLooping;
    
    /**
     * Refreshes the filters.
     * 
     * @param localCacheOnly if true, explicitly uses the local caches for returning
     * the filters' nations lists instead of allowing the possibility for using 
     * the global cache, daily dump file, or calls to the server.
     */
    public void refreshFilters(boolean localCacheOnly)
    {
        Recipients.clear();
        Filters.forEach((filter) -> { filter.applyFilter(Recipients, localCacheOnly); });
    }
    
    /**
     * Adds new filter.
     * 
     * @param filter
     */
    public void addFilter(Filter filter)
    {
        filter.applyFilter(Recipients, false);
        Filters.add(filter);
        refreshFilters(true);
    }
    
    /**
     * Gives the number of recipients.
     * 
     * @return 
     */
    public int numberOfRecipients()
    {
        return Recipients.size();
    }
    
    /**
     * Gets a copy of the Recipients.
     * 
     * @return 
     */
    public Set<String> getRecipients()
    {
        return new HashSet<>(Recipients);
    }
    
    /**
     * Removes the filter with the given index.
     * 
     * @param index 
     */
    public void removeFilterAt(int index)
    {
        Filters.remove(index);
        refreshFilters(true);
    }
    
    /**
     * Starts sending the telegram to the recipients in a new thread.
     * Throws IllegalArgumentException if the variables are not properly set.
     * 
     */
    public void startSending()
    {
        // Make sure all inputs are valid.
        if (ClientKey == null || ClientKey.isEmpty())
            throw new IllegalArgumentException("Please supply a Client Key!");      
        if (TelegramId == null || TelegramId.isEmpty())
            throw new IllegalArgumentException("Please supply a Telegram Id!");      
        if (SecretKey == null || SecretKey.isEmpty())
            throw new IllegalArgumentException("Please supply a Secret Key!");
        
        refreshFilters(true);   // Refresh filters one last time before checking # of recipients
        
        if (numberOfRecipients() == 0)
            throw new IllegalArgumentException("Please supply at least one recipient!"); 
        
        removeOldRecipients();  // Remove old recipients.
        NSAPI.setUserAgent(String.format(USER_AGENT, ClientKey)); // Update user agent.
        
        // Check to make sure the thread is not already running to prevent synchronization issues.
        if (TelegramThread != null && TelegramThread.isAlive())
            throw new IllegalThreadStateException("Telegram thread already running!");
        
        // Prepare thread, then run it.
        TelegramThread = new Thread(new SendTelegramsRunnable(this, Recipients, Listeners,
            NO_ADDRESSEES_FOUND_TIMEOUT, History));       
        TelegramThread.start();
    }
    
    /**
     * Stops sending the telegram to the recipients.
     */
    public void stopSending()
    {
        if (TelegramThread != null)
            TelegramThread.interrupt();
    }
    
    /**
     * Removes invalid recipients from Recipients.
     */
    public void removeOldRecipients()
    {
        for (final Iterator<String> it = Recipients.iterator(); it.hasNext();)
        {
            final String recipient = it.next();
            final Reason reason = History.get(new Tuple(TelegramId, recipient));
            
            if (reason != null)
            {
                Recipients.remove(recipient);   // Remove recipient
                final RecipientRemovedEvent event = new RecipientRemovedEvent(this, recipient, reason); // Create event
                synchronized(Listeners) // fire event
                {
                    Listeners.stream().forEach((tsl) ->
                    {
                        tsl.handleRecipientRemoved(event);
                    });
                }
            }       
        }
    }
    
    /**
     * Registers new telegram manager listeners.
     * 
     * @param newlisteners the listeners to register
     */
    public void addListeners(TelegramManagerListener... newlisteners)
    {
        synchronized (Listeners)
        {
            Listeners.addAll(Arrays.asList(newlisteners));
        }
    }
}
