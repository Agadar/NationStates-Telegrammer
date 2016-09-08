package com.github.agadar.nstelegram;

import java.util.HashMap;
import java.util.Map;

/**
 * Addressees types, with corresponding string explanations.
 * 
 * @author marti
 */
public enum AddresseesType
{
    ALL("All"),
    DELEGATES_INCL("Delegates (include)"),
    DELEGATES_EXCL("Delegates (exclude)"),
    NATIONS_INCL("Nations (include)"),
    NATIONS_EXCL("Nations (exclude)"),
    NEW_NATIONS("New Nations"),
    REGIONS_INCL("Regions (include)"),
    REGIONS_EXCL("Regions (exclude)"),
    WA_MEMBERS_INCL("WA Members (include)"),
    WA_MEMBERS_EXCL("WA Members (exclude)"),
    ;
     
    // Map for looking up addressees type via its explanation.
    private final static Map<String, AddresseesType> reverse = new HashMap<>();
    
    // Static initializer for filling the reverse map.
    static
    {
        for (AddresseesType type : AddresseesType.values())
        {
            reverse.put(type.Text, type);
        }
    }
    
    // Explanation.
    private final String Text;

    /**
     * Constructor.
     * 
     * @param text 
     */
    private AddresseesType(String text)
    {
        this.Text = text;
    }
    
    /**
     * Gets the string explanation.
     * 
     * @return 
     */
    public String getText()
    {
        return Text;
    }
    
    /**
     * Looks up an addressees type via its explanation. May return null.
     * 
     * @param text
     * @return 
     */
    public static AddresseesType getViaText(String text)
    {
        return reverse.get(text);
    }
}
