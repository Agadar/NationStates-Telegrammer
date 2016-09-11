package com.github.agadar.nstelegram;

import com.github.agadar.nsapi.NSAPI;
import com.github.agadar.nsapi.event.TelegramSentEvent;
import com.github.agadar.nsapi.event.TelegramSentListener;
import java.awt.event.ItemEvent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.DefaultCaret;

/**
 * The main GUI of this application.
 *
 * @author Agadar <https://github.com/Agadar/>
 */
public class NSTelegramForm extends javax.swing.JFrame implements TelegramSentListener
{
    // Form title.
    public final static String FORM_TITLE = "Agadar's NationStates Telegrammer 1.0.0";
    // Key values etc. for this application's properties.
    private final static String CLIENT_KEY = "clientKey";
    private final static String TELEGRAM_ID = "telegramId";
    private final static String SECRET_KEY = "secretKey";
    private final static String IS_RECRUITMENT = "isRecruitment";
    // User agent for this application.
    private final static String USER_AGENT = 
        "Agadar's Telegrammer (https://github.com/Agadar/NationStates-Telegrammer)";
    // Short reference to telegram manager.
    private final TelegramManager tm = TelegramManager.Instance;
    
    public NSTelegramForm()
    {
        initComponents();
        // Sets the output textarea such that it auto-scrolls down.
        ((DefaultCaret) TextOutput.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        NSAPI.setUserAgent(USER_AGENT); // Set the user agent.
        
        // Set fields according to values retrieved from properties file.
        Properties props = PropertiesHelper.loadProperties();
        TxtFieldClientKey.setText(props.getProperty(CLIENT_KEY));
        TxtFieldTelegramId.setText(props.getProperty(TELEGRAM_ID));
        TxtFieldSecretKey.setText(props.getProperty(SECRET_KEY));
        RadioBtnRecruitment.setSelected(Boolean.valueOf(props.getProperty(IS_RECRUITMENT)));
        
        // Set output textarea, for consistency's sake.
        TextOutput.setText(duration());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        BtnGrpTelegramType = new javax.swing.ButtonGroup();
        PanelTelegram = new javax.swing.JPanel();
        LabelTelegramId = new javax.swing.JLabel();
        TxtFieldTelegramId = new javax.swing.JTextField();
        LabelSecretKey = new javax.swing.JLabel();
        TxtFieldSecretKey = new javax.swing.JTextField();
        LabelClientKey = new javax.swing.JLabel();
        LabelSendAs = new javax.swing.JLabel();
        RadioBtnNormal = new javax.swing.JRadioButton();
        TxtFieldClientKey = new javax.swing.JTextField();
        RadioBtnRecruitment = new javax.swing.JRadioButton();
        PanelAddressees = new javax.swing.JPanel();
        ScrollPaneAddressees = new javax.swing.JScrollPane();
        ListAddressees = new javax.swing.JList<>();
        ButtonRemoveAddressee = new javax.swing.JButton();
        ComboBoxAddresseeType = new javax.swing.JComboBox<>();
        TextFieldAddresseeVar = new javax.swing.JTextField();
        ButtonAddAddressee = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextOutput = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        BtnStart = new javax.swing.JButton();
        BtnStop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(NSTelegramForm.FORM_TITLE);
        setName("NSTelegramFrame"); // NOI18N
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        PanelTelegram.setBorder(javax.swing.BorderFactory.createTitledBorder("Telegram"));

        LabelTelegramId.setLabelFor(TxtFieldTelegramId);
        LabelTelegramId.setText("Telegram Id:");
        LabelTelegramId.setName("LabelTelegramId"); // NOI18N

        TxtFieldTelegramId.setName("TxtFieldTelegramId"); // NOI18N

        LabelSecretKey.setLabelFor(TxtFieldSecretKey);
        LabelSecretKey.setText("Secret Key:");
        LabelSecretKey.setName("LabelSecretKey"); // NOI18N

        TxtFieldSecretKey.setName("TxtFieldSecretKey"); // NOI18N

        LabelClientKey.setLabelFor(TxtFieldClientKey);
        LabelClientKey.setText("Client Key:");
        LabelClientKey.setName("LabelClientKey"); // NOI18N

        LabelSendAs.setText("Send as...");
        LabelSendAs.setName("LabelSendAs"); // NOI18N

        BtnGrpTelegramType.add(RadioBtnNormal);
        RadioBtnNormal.setSelected(true);
        RadioBtnNormal.setText("normal telegram");
        RadioBtnNormal.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                RadioBtnNormalItemStateChanged(evt);
            }
        });

        TxtFieldClientKey.setName("TxtFieldClientKey"); // NOI18N

        BtnGrpTelegramType.add(RadioBtnRecruitment);
        RadioBtnRecruitment.setText("recruitment telegram");
        RadioBtnRecruitment.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                RadioBtnRecruitmentItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout PanelTelegramLayout = new javax.swing.GroupLayout(PanelTelegram);
        PanelTelegram.setLayout(PanelTelegramLayout);
        PanelTelegramLayout.setHorizontalGroup(
            PanelTelegramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTelegramLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTelegramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(PanelTelegramLayout.createSequentialGroup()
                        .addComponent(LabelTelegramId)
                        .addGap(18, 18, 18)
                        .addComponent(TxtFieldTelegramId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTelegramLayout.createSequentialGroup()
                        .addComponent(LabelClientKey)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtFieldClientKey, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTelegramLayout.createSequentialGroup()
                        .addGroup(PanelTelegramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelSecretKey)
                            .addComponent(LabelSendAs))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelTelegramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RadioBtnNormal)
                            .addComponent(TxtFieldSecretKey, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RadioBtnRecruitment))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTelegramLayout.setVerticalGroup(
            PanelTelegramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTelegramLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTelegramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelClientKey)
                    .addComponent(TxtFieldClientKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelTelegramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTelegramId)
                    .addComponent(TxtFieldTelegramId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelTelegramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelSecretKey)
                    .addComponent(TxtFieldSecretKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelTelegramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelSendAs)
                    .addComponent(RadioBtnNormal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioBtnRecruitment)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelAddressees.setBorder(javax.swing.BorderFactory.createTitledBorder("Addressees"));
        PanelAddressees.setPreferredSize(new java.awt.Dimension(289, 172));

        ScrollPaneAddressees.setName("ScrollPaneAddressees"); // NOI18N

        ListAddressees.setModel(new DefaultListModel());
        ListAddressees.setName("ListAddressees"); // NOI18N
        ListAddressees.addListSelectionListener(new javax.swing.event.ListSelectionListener()
        {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt)
            {
                ListAddresseesValueChanged(evt);
            }
        });
        ScrollPaneAddressees.setViewportView(ListAddressees);

        ButtonRemoveAddressee.setText("Remove");
        ButtonRemoveAddressee.setEnabled(false);
        ButtonRemoveAddressee.setName("ButtonRemoveAddressee"); // NOI18N
        ButtonRemoveAddressee.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonRemoveAddresseeActionPerformed(evt);
            }
        });

        ComboBoxAddresseeType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Delegates (include)", "Delegates (exclude)", "Nations (include)", "Nations (exclude)", "New Nations", "Regions (include)", "Regions (exclude)", "WA Members (include)", "WA Members (exclude)" }));
        ComboBoxAddresseeType.setName("ComboBoxAddresseeType"); // NOI18N
        ComboBoxAddresseeType.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                ComboBoxAddresseeTypeItemStateChanged(evt);
            }
        });

        TextFieldAddresseeVar.setEditable(false);
        TextFieldAddresseeVar.setName("TextFieldAddresseeVar"); // NOI18N

        ButtonAddAddressee.setText("Add");
        ButtonAddAddressee.setName("ButtonAddAddressee"); // NOI18N
        ButtonAddAddressee.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonAddAddresseeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelAddresseesLayout = new javax.swing.GroupLayout(PanelAddressees);
        PanelAddressees.setLayout(PanelAddresseesLayout);
        PanelAddresseesLayout.setHorizontalGroup(
            PanelAddresseesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAddresseesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAddresseesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboBoxAddresseeType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScrollPaneAddressees, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addGroup(PanelAddresseesLayout.createSequentialGroup()
                        .addComponent(ButtonRemoveAddressee, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonAddAddressee, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                    .addComponent(TextFieldAddresseeVar))
                .addContainerGap())
        );
        PanelAddresseesLayout.setVerticalGroup(
            PanelAddresseesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAddresseesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneAddressees, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboBoxAddresseeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextFieldAddresseeVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelAddresseesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonRemoveAddressee)
                    .addComponent(ButtonAddAddressee))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));

        TextOutput.setColumns(20);
        TextOutput.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        TextOutput.setRows(5);
        jScrollPane1.setViewportView(TextOutput);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        BtnStart.setText("Start sending");
        BtnStart.setName("ButtonRemoveAddressee"); // NOI18N
        BtnStart.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnStartActionPerformed(evt);
            }
        });

        BtnStop.setText("Stop sending");
        BtnStop.setEnabled(false);
        BtnStop.setName("ButtonRemoveAddressee"); // NOI18N
        BtnStop.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(BtnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnStart)
                    .addComponent(BtnStop))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelAddressees, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTelegram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelTelegram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanelAddressees, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Called by the Start button. Retrieves values from textboxes, sets the GUI
     * components properly, and tells the TelegramManager to start sending.
     * 
     * @param evt 
     */
    private void BtnStartActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnStartActionPerformed
    {//GEN-HEADEREND:event_BtnStartActionPerformed
      
        // Retrieve values from textboxes.
        String clientKey = TxtFieldClientKey.getText().trim();
        String telegramId = TxtFieldTelegramId.getText().trim();
        String secretKey = TxtFieldSecretKey.getText().trim();
        boolean isRecruitment = RadioBtnRecruitment.isSelected();
        
        // Do null/empy checks on retrieved values.
        if (clientKey == null || clientKey.isEmpty())
        {
            TextOutput.setText("Please supply a Client Key!");
            return;
        }        
        if (telegramId == null || telegramId.isEmpty())
        {
            TextOutput.setText("Please supply a Telegram Id!");
            return;
        }        
        if (secretKey == null || secretKey.isEmpty())
        {
            TextOutput.setText("Please supply a Secret Key!");
            return;
        }
        
        // If no addressees were selected, make it known and cancel.
        if (tm.numberOfAddressees() == 0)
        {
            TextOutput.setText("Please supply at least one addressee!");
            return;
        }
        
        // Set GUI components.
        updateGui(true);
        TextOutput.setText(duration());
        
        // Call telegram manager to start sending.
        tm.startSending(clientKey, telegramId, secretKey, isRecruitment, this);
    }//GEN-LAST:event_BtnStartActionPerformed

    /**
     * Called by the Stop button. Sets the GUI components properly, and tells
     * the telegram manager to stop sending.
     * 
     * @param evt 
     */
    private void BtnStopActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnStopActionPerformed
    {//GEN-HEADEREND:event_BtnStopActionPerformed
        // Call telegram manager to stop sending.
        tm.stopSending();
        
        // Set GUI components.
        updateGui(false);
    }//GEN-LAST:event_BtnStopActionPerformed

    /**
     * Called when an item in the addressee-type combo box has been selected.
     * Properly enables or disables the textfield for nation/region names.
     * 
     * @param evt 
     */
    private void ComboBoxAddresseeTypeItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_ComboBoxAddresseeTypeItemStateChanged
    {//GEN-HEADEREND:event_ComboBoxAddresseeTypeItemStateChanged
        // Only run this code if something was SELECTED.
        if (evt.getStateChange() != ItemEvent.SELECTED) 
        {
            return;
        }
        
        TextFieldAddresseeVar.setText("");  // Clear the textfield in question.
        
        // According to which item was selected, enable or disable the textfield.
        switch (AddresseesType.getViaText((String) evt.getItem()))
        {
            case ALL:
                TextFieldAddresseeVar.setEditable(false);
                break;
            case DELEGATES_INCL:
                TextFieldAddresseeVar.setEditable(false);
                break;
            case DELEGATES_EXCL:
                TextFieldAddresseeVar.setEditable(false);
                break;
            case NATIONS_INCL:
                TextFieldAddresseeVar.setEditable(true);
                break;
            case NATIONS_EXCL:
                TextFieldAddresseeVar.setEditable(true);
                break;
            case NEW_NATIONS:
                TextFieldAddresseeVar.setEditable(false);
                break;
            case REGIONS_INCL:
                TextFieldAddresseeVar.setEditable(true);
                break;
            case REGIONS_EXCL:
                TextFieldAddresseeVar.setEditable(true);
                break;
            case WA_MEMBERS_INCL:
                TextFieldAddresseeVar.setEditable(false);
                break;
            case WA_MEMBERS_EXCL:
                TextFieldAddresseeVar.setEditable(false);
                break;
        }
    }//GEN-LAST:event_ComboBoxAddresseeTypeItemStateChanged

    /**
     * Called when anywhere in the form was clicked. Used for de-selecting an
     * addressee in the addressees list and disabling the remove-button.
     * 
     * @param evt 
     */
    private void formMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_formMouseClicked
    {//GEN-HEADEREND:event_formMouseClicked
        ListAddressees.clearSelection();
        ButtonRemoveAddressee.setEnabled(false); 
    }//GEN-LAST:event_formMouseClicked

    /**
     * Called when the 'add addressee' button was clicked. Retrieves from the
     * server the nation names corresponding to the addressees to add (if applicable), 
     * tells the telegram manager to add these to its sending list, and updates 
     * the GUI to reflect the added addressees.
     * 
     * @param evt 
     */
    private void ButtonAddAddresseeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonAddAddresseeActionPerformed
    {//GEN-HEADEREND:event_ButtonAddAddresseeActionPerformed
        final DefaultListModel model = ((DefaultListModel)ListAddressees.getModel());
        List<String> addressees;
        boolean add = true; // if true, add. if false, remove.
        String type;
        
        // Set above variables according to addressees type selected.
        switch (AddresseesType.getViaText((String) ComboBoxAddresseeType.getSelectedItem()))
        {
            case ALL:
                addressees = AddresseesHelper.allNations();        
                type = AddresseesType.ALL.getText();
                break;
            case DELEGATES_INCL:
                addressees = AddresseesHelper.delegates();
                type = AddresseesType.DELEGATES_INCL.getText();
                break;
            case DELEGATES_EXCL:
                addressees = AddresseesHelper.delegates();
                type = AddresseesType.DELEGATES_EXCL.getText();
                add = false;
                break;
            case NATIONS_INCL:
                addressees = stringToStringList(TextFieldAddresseeVar.getText());
                type = AddresseesType.NATIONS_INCL.getText() + ": " + addressees;
                break;
            case NATIONS_EXCL:
                addressees = stringToStringList(TextFieldAddresseeVar.getText());
                type = AddresseesType.NATIONS_EXCL.getText() + ": " + addressees;
                add = false;
                break;
            case NEW_NATIONS:
                addressees = AddresseesHelper.newNations();
                type = AddresseesType.NEW_NATIONS.getText();
                break;
            case REGIONS_INCL:
                addressees = new ArrayList<>();
                List<String> regions_incl = stringToStringList(TextFieldAddresseeVar.getText());               
                regions_incl.stream().forEach((region) ->
                {
                    addressees.addAll(AddresseesHelper.nationsInRegion(region));
                });
                type = AddresseesType.REGIONS_INCL.getText() + ": " + regions_incl;
                break;
            case REGIONS_EXCL:
                addressees = new ArrayList<>();
                List<String> regions_excl = stringToStringList(TextFieldAddresseeVar.getText());              
                regions_excl.stream().forEach((region) ->
                {
                    addressees.addAll(AddresseesHelper.nationsInRegion(region));
                });
                type = AddresseesType.REGIONS_EXCL.getText() + ": " + regions_excl;
                add = false;
                break;
            case WA_MEMBERS_INCL:
                addressees = AddresseesHelper.worldAssemblyMembers();
                type = AddresseesType.WA_MEMBERS_INCL.getText();
                break;
            case WA_MEMBERS_EXCL:
                addressees = AddresseesHelper.worldAssemblyMembers();
                type = AddresseesType.WA_MEMBERS_EXCL.getText();
                add = false;
                break;
            default:
                return;
        }
        
        // Add/remove addressees from telegram manager, and set the addressees
        // listbox model to reflect the new addressees.
        if (add)
        {
            tm.addAddressees(addressees); 
        }
        else
        {
            tm.removeAddressees(addressees); 
        }
        model.addElement(type);
        
        // Calculate estimated duration to send telegrams, then set it to output.
        TextOutput.setText(duration());
    }//GEN-LAST:event_ButtonAddAddresseeActionPerformed

    /**
     * Called when the 'remove addressee' button was clicked. Tells the telegram
     * manager to remove the selected addressees, and updates the GUI to reflect the change.
     * 
     * @param evt 
     */
    private void ButtonRemoveAddresseeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonRemoveAddresseeActionPerformed
    {//GEN-HEADEREND:event_ButtonRemoveAddresseeActionPerformed
        int index = ListAddressees.getSelectedIndex();
        tm.removeStep(index);
        ((DefaultListModel)ListAddressees.getModel()).remove(index);
        
        ButtonRemoveAddressee.setEnabled(false);
        ListAddressees.clearSelection();
        TextOutput.setText(duration());
    }//GEN-LAST:event_ButtonRemoveAddresseeActionPerformed

    /**
     * Called when the application is closing. Makes sure the properties file
     * is updated with the new values in the textboxes.
     * 
     * @param evt 
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        // Store relevant variables to properties file.
        Properties props = new Properties();
        props.setProperty(CLIENT_KEY, TxtFieldClientKey.getText());
        props.setProperty(TELEGRAM_ID, TxtFieldTelegramId.getText());
        props.setProperty(SECRET_KEY, TxtFieldSecretKey.getText());
        props.setProperty(IS_RECRUITMENT, Boolean.toString(RadioBtnRecruitment.isSelected()));
        PropertiesHelper.saveProperties(props);
    }//GEN-LAST:event_formWindowClosing

    /**
     * Called when an item in the addressees list is selected. Enables the
     * 'remove addressee'-button.
     * 
     * @param evt 
     */
    private void ListAddresseesValueChanged(javax.swing.event.ListSelectionEvent evt)//GEN-FIRST:event_ListAddresseesValueChanged
    {//GEN-HEADEREND:event_ListAddresseesValueChanged
        if (!evt.getValueIsAdjusting() && ListAddressees.getSelectedIndex() != -1)
        {
            ButtonRemoveAddressee.setEnabled(true);
        }
    }//GEN-LAST:event_ListAddresseesValueChanged

    /**
     * Called when the recruitment radio button item state has changed. Updates
     * the output textarea with a newly calculated estimate.
     * 
     * @param evt 
     */
    private void RadioBtnRecruitmentItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_RadioBtnRecruitmentItemStateChanged
    {//GEN-HEADEREND:event_RadioBtnRecruitmentItemStateChanged
        TextOutput.setText(duration());
    }//GEN-LAST:event_RadioBtnRecruitmentItemStateChanged

    /**
     * Called when the 'normal telegram' radio button item state has changed. Updates
     * the output textarea with a newly calculated estimate.
     * 
     * @param evt 
     */
    private void RadioBtnNormalItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_RadioBtnNormalItemStateChanged
    {//GEN-HEADEREND:event_RadioBtnNormalItemStateChanged
        TextOutput.setText(duration());
    }//GEN-LAST:event_RadioBtnNormalItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        try
        {
            // Just use the windows look and feel, because that's what we see in
            // the designer. This way, what we see is what we get.
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(() -> 
            {
                NSTelegramForm form = new NSTelegramForm();
                form.setLocationRelativeTo(null);
                form.setVisible(true);
            });
        }
        catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException |
                UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(NSTelegramForm.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BtnGrpTelegramType;
    private javax.swing.JButton BtnStart;
    private javax.swing.JButton BtnStop;
    private javax.swing.JButton ButtonAddAddressee;
    private javax.swing.JButton ButtonRemoveAddressee;
    private javax.swing.JComboBox<String> ComboBoxAddresseeType;
    private javax.swing.JLabel LabelClientKey;
    private javax.swing.JLabel LabelSecretKey;
    private javax.swing.JLabel LabelSendAs;
    private javax.swing.JLabel LabelTelegramId;
    private javax.swing.JList<String> ListAddressees;
    private javax.swing.JPanel PanelAddressees;
    private javax.swing.JPanel PanelTelegram;
    private javax.swing.JRadioButton RadioBtnNormal;
    private javax.swing.JRadioButton RadioBtnRecruitment;
    private javax.swing.JScrollPane ScrollPaneAddressees;
    private javax.swing.JTextField TextFieldAddresseeVar;
    private javax.swing.JTextArea TextOutput;
    private javax.swing.JTextField TxtFieldClientKey;
    private javax.swing.JTextField TxtFieldSecretKey;
    private javax.swing.JTextField TxtFieldTelegramId;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    /**
     * Called when the telegram manager has sent a telegram. Prints information
     * to the output textarea. If the telegram manager has sent the final telegram,
     * then the GUI is updated to reflect this.
     * 
     * @param event 
     */
    @Override
    public void handleTelegramSent(TelegramSentEvent event)
    {
        // Print info to output.
        String message = "[" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "]";        
        if (event.Queued)
        {
            message += " queued telegram for '" + event.Addressee + "'\n";
        }
        else
        {
            message += " failed to queue telegram for '" + event.Addressee + "'\n"
                    + event.ErrorMessage + "\n";
        }       
        TextOutput.append(message);
        
        // If all telegrams were sent, reset the buttons.
        if (event.PositionInQuery + 1 == tm.numberOfAddressees())
        {
            updateGui(false);
        }
    }
    
    /**
     * Updates the GUI according to whether we've begun sending telegrams, or
     * stopped sending telegrams.
     * 
     * @param sending 
     */
    private void updateGui(boolean sending)
    {
        if (sending)
        {
            BtnStart.setEnabled(false);
            BtnStop.setEnabled(true);
            ListAddressees.setEnabled(false);
            ButtonAddAddressee.setEnabled(false);
            ButtonRemoveAddressee.setEnabled(false);
            TxtFieldClientKey.setEditable(false);
            TxtFieldTelegramId.setEditable(false);
            TxtFieldSecretKey.setEditable(false);
            RadioBtnNormal.setEnabled(false);
            RadioBtnRecruitment.setEnabled(false);
            ComboBoxAddresseeType.setEnabled(false);
        }
        else
        {
            BtnStart.setEnabled(true);
            BtnStop.setEnabled(false);
            ListAddressees.setEnabled(true);
            ButtonAddAddressee.setEnabled(true);
            TxtFieldClientKey.setEditable(true);
            TxtFieldTelegramId.setEditable(true);
            TxtFieldSecretKey.setEditable(true);
            RadioBtnNormal.setEnabled(true);
            RadioBtnRecruitment.setEnabled(true);
            ComboBoxAddresseeType.setEnabled(true);
        }
    }
    
    /**
     * Calculates the estimated duration of sending all the telegrams, and 
     * returns it in a formatted string.
     * 
     * @return 
     */
    private String duration()
    {
        int estimatedDuration = Math.max(tm.numberOfAddressees() - 1, 0) 
                                * (RadioBtnNormal.isSelected() ? 31 : 181);
        int hours = estimatedDuration / 3600;
        int minutes = estimatedDuration % 3600 / 60;
        int seconds = estimatedDuration % 3600 % 60;
        return String.format("Addressees selected: %s%nEstimated duration: "
                + "%s hours, %s minutes, %s seconds\n"
                , tm.numberOfAddressees(), hours, minutes, seconds);
    }
    
    /**
     * Converts a comma-separated string to a list of strings.
     * 
     * @param string
     * @return 
     */
    private static List<String> stringToStringList(String string)
    {
        List<String> asList = Arrays.asList(string.trim().split("\\s*,\\s*"));
        return asList.size() == 1 && asList.get(0).isEmpty() ? new ArrayList<>() : asList;
    }
}
