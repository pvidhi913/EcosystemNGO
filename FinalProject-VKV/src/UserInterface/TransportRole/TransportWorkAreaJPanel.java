/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.TransportRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.TransportOrganization;
import Business.Organization.VolunteerOrganization;
import Business.Role.TransportRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EducationVolunteerWorkRequest;
import Business.WorkQueue.HealthPharmacyWorkRequest;
import Business.WorkQueue.VolunteerInventoryWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vidhi
 */
public class TransportWorkAreaJPanel extends javax.swing.JPanel {

    private TransportOrganization transportOrganization;
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private Enterprise enterprise;
    
    /**
     * Creates new form TransportWorkAreaJPanel
     */
    public TransportWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization,  EcoSystem business, Enterprise enterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.enterprise = enterprise;
        this.transportOrganization = (TransportOrganization) organization;
        valueLabel.setText(enterprise.getName());
        populateOrders();
        populateAssignedOrders();
    }
    
    public void populateOrders(){
        
        DefaultTableModel model = (DefaultTableModel) ordersJTable.getModel();
        
        model.setRowCount(0);
        for (Iterator<WorkRequest> it = transportOrganization.getWorkQueue().getWorkRequestList().iterator(); it.hasNext();) {
            
            WorkRequest r = (WorkRequest) it.next();
            if(r instanceof VolunteerInventoryWorkRequest){
                VolunteerInventoryWorkRequest request = (VolunteerInventoryWorkRequest) r;
                if(request.getStatus().equalsIgnoreCase("Ordered")){
                    Object[] row = new Object[5];
                    row[0]= request;
                    row[1]=request.getSenderAddress();
                    row[2]= request.getRecieverAddress();
                    row[3] = request.getStatus();
                    model.addRow(row);
                }
            }else{
                HealthPharmacyWorkRequest request = (HealthPharmacyWorkRequest) r;
                if(request.getStatus().equalsIgnoreCase("Delivery Requested")){
                    Object[] row = new Object[5];
                    row[0]= request;
                    row[2]= request.getSenderAddress();
                    row[1]= request.getRecieverAddress();
                    row[3] = request.getStatus();
                    model.addRow(row);
                }
            }
                
                
        }
    }
    
    public void populateDeliveredOrders(){
        
        DefaultTableModel model = (DefaultTableModel)assignedJTable.getModel();
        
        model.setRowCount(0);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy");
        
        for (Iterator<WorkRequest> it = userAccount.getWorkQueue().getWorkRequestList().iterator(); it.hasNext();) {

         
              WorkRequest wr = (WorkRequest) it.next();
              if(wr instanceof VolunteerInventoryWorkRequest){
              VolunteerInventoryWorkRequest request = (VolunteerInventoryWorkRequest) wr;
                
              
                        if(request.getStatus().equalsIgnoreCase("Delivered")){
                        
                        Object[] row = new Object[6];
                        row[0] = request;
                        row[1] = request.getSender().getEmployee().getName();
                        row[2] = request.getReceiver().getEmployee().getName();
                        Date date = request.getPickupDate();
                        String pickDate = formatter.format(date);
                        row[3] = pickDate;
                        Date date1 = request.getExpectedDelivery();
                        String deliverDate = formatter.format(date1);
                        row[4] = deliverDate;
                        row[5] = request.getStatus();
                        model.addRow(row);
                        
                        }
   

                }else{
                    HealthPharmacyWorkRequest request = (HealthPharmacyWorkRequest) wr;

                            
                            if(request.getStatus().equalsIgnoreCase("Delivered")){
                                
                            Object[] row = new Object[6];
                            row[0] = request;
                            row[2] = request.getSender().getEmployee().getName();
                            row[1] = request.getReceiver().getEmployee().getName();
                            Date date = request.getPickupDate();
                            String pickDate = formatter.format(date);
                            row[3] = pickDate;
                            Date date1 = request.getExpectedDelivery();
                            String deliverDate = formatter.format(date1);
                            row[4] = deliverDate;
                            row[5] = request.getStatus();
                            model.addRow(row);
                        
                            }

            }
        }
                        
        
        
    }
    
    public void populateDeliveryAssignedOrders(){
        
        DefaultTableModel model = (DefaultTableModel)assignedJTable.getModel();
        
        model.setRowCount(0);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy");
        
        for (Iterator<WorkRequest> it = userAccount.getWorkQueue().getWorkRequestList().iterator(); it.hasNext();) {

             WorkRequest wr = (WorkRequest) it.next();
              if(wr instanceof VolunteerInventoryWorkRequest){
                  
              VolunteerInventoryWorkRequest request = (VolunteerInventoryWorkRequest) wr;
                
              
                        if(request.getStatus().equalsIgnoreCase("Delivery Assigned")){
                        
                        Object[] row = new Object[6];
                        row[0] = request;
                        row[1] = request.getSender().getEmployee().getName();
                        row[2] = request.getReceiver().getEmployee().getName();
                        Date date = request.getPickupDate();
                        String pickDate = formatter.format(date);
                        row[3] = pickDate;
                        Date date1 = request.getExpectedDelivery();
                        String deliverDate = formatter.format(date1);
                        row[4] = deliverDate;
                        row[5] = request.getStatus();
                        model.addRow(row);
                        
                    }
 
                }
              
              else{
                  
                    HealthPharmacyWorkRequest request = (HealthPharmacyWorkRequest) wr;

                            
                            if(request.getStatus().equalsIgnoreCase("Delivery Assigned")){
                                
                            Object[] row = new Object[6];
                            row[0] = request;
                            row[2] = request.getSender().getEmployee().getName();
                            row[1] = request.getReceiver().getEmployee().getName();
                            Date date = request.getPickupDate();
                            String pickDate = formatter.format(date);
                            row[3] = pickDate;
                            Date date1 = request.getExpectedDelivery();
                            String deliverDate = formatter.format(date1);
                            row[4] = deliverDate;
                            row[5] = request.getStatus();
                            model.addRow(row);
                        
                        }
            }
        }
        
    }
    
    public void populateAssignedOrders(){
        
        DefaultTableModel model = (DefaultTableModel)assignedJTable.getModel();
        
        model.setRowCount(0);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy");
        
        for (Iterator<WorkRequest> it = userAccount.getWorkQueue().getWorkRequestList().iterator(); it.hasNext();) {

            WorkRequest wr = (WorkRequest) it.next();
            if(wr instanceof VolunteerInventoryWorkRequest){
                VolunteerInventoryWorkRequest request = (VolunteerInventoryWorkRequest) wr;
    
                        Object[] row = new Object[6];
                        row[0] = request;
                        row[1] = request.getSender().getEmployee().getName();
                        row[2] = request.getReceiver().getEmployee().getName();
                        Date date = request.getPickupDate();
                        String pickDate = formatter.format(date);
                        row[3] = pickDate;
                        Date date1 = request.getExpectedDelivery();
                        String deliverDate = formatter.format(date1);
                        row[4] = deliverDate;
                        row[5] = request.getStatus();
                        model.addRow(row);

            } else{
                HealthPharmacyWorkRequest request = (HealthPharmacyWorkRequest) wr;
                    
                        Object[] row = new Object[6];
                        row[0] = request;
                        row[2] = request.getSender().getEmployee().getName();
                        row[1] = request.getReceiver().getEmployee().getName();
                        Date date = request.getPickupDate();
                        String pickDate = formatter.format(date);
                        row[3] = pickDate;
                        Date date1 = request.getExpectedDelivery();
                        String deliverDate = formatter.format(date1);
                        row[4] = deliverDate;
                        row[5] = request.getStatus();
                        model.addRow(row);
        }} 
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ordersJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        senderAddress = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        recieverAddress = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        assignJButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        contactjTextField = new javax.swing.JTextField();
        pickUpDate = new com.toedter.calendar.JDateChooser();
        deliveryDate = new com.toedter.calendar.JDateChooser();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        assignedJTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        senderAdd = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        recieverAdd = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        recieverContact = new javax.swing.JTextField();
        senderContact = new javax.swing.JTextField();
        sender = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        reciever = new javax.swing.JTextField();
        deliverButton = new javax.swing.JButton();
        filterComboBox = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jTabbedPane1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(180, 195, 195));

        ordersJTable.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        ordersJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Sender Address", "Reciever Address", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ordersJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordersJTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ordersJTable);

        jLabel1.setText("Sender Address");

        jLabel2.setText("Reciever Address ");

        senderAddress.setColumns(20);
        senderAddress.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        senderAddress.setRows(5);
        jScrollPane2.setViewportView(senderAddress);

        recieverAddress.setColumns(20);
        recieverAddress.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        recieverAddress.setRows(5);
        jScrollPane3.setViewportView(recieverAddress);

        jLabel25.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Delivery Work Area");

        assignJButton.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel3.setText("PickUp Date");

        jLabel4.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel4.setText("Delivery Date");

        jLabel5.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel5.setText("Contact Number");

        contactjTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        contactjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactjTextFieldActionPerformed(evt);
            }
        });

        pickUpDate.setToolTipText("");
        pickUpDate.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        deliveryDate.setToolTipText("");
        deliveryDate.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        enterpriseLabel.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        enterpriseLabel.setText("EnterPrise -");

        valueLabel.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        valueLabel.setText("<value>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 76, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(271, 271, 271))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(93, 93, 93)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(assignJButton)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(contactjTextField)
                            .addComponent(pickUpDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deliveryDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(enterpriseLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valueLabel)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel25)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pickUpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)
                        .addComponent(deliveryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(contactjTextField)
                        .addGap(18, 18, 18)
                        .addComponent(assignJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(440, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Home", jPanel1);

        jPanel2.setBackground(new java.awt.Color(180, 195, 195));

        jLabel7.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Delivery Order History");

        assignedJTable.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        assignedJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Sender", "Reciever", "PickUp Date", "Delivery Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        assignedJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                assignedJTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(assignedJTable);

        jLabel6.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel6.setText("Sender Address");

        jLabel8.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel8.setText("Reciever Address ");

        senderAdd.setColumns(20);
        senderAdd.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        senderAdd.setRows(5);
        jScrollPane5.setViewportView(senderAdd);

        recieverAdd.setColumns(20);
        recieverAdd.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        recieverAdd.setRows(5);
        jScrollPane6.setViewportView(recieverAdd);

        jLabel9.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel9.setText("Sender Contact");

        jLabel10.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel10.setText("Reciever Contact ");

        recieverContact.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        senderContact.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        sender.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        sender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senderActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel11.setText("Sender");

        jLabel12.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel12.setText("Reciever ");

        reciever.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        deliverButton.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        deliverButton.setText("Delivered");
        deliverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliverButtonActionPerformed(evt);
            }
        });

        filterComboBox.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        filterComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Undelivered", "Delivered"}));
        filterComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterComboBoxItemStateChanged(evt);
            }
        });
        filterComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filterComboBoxMouseClicked(evt);
            }
        });
        filterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterComboBoxActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        jLabel13.setText("Filter By: ");

        jLabel14.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel14.setText("Status");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deliverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(senderContact, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(222, 222, 222)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(recieverContact, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(sender, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(117, 117, 117)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(reciever, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addComponent(deliverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reciever, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recieverContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senderContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(329, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("My Orders", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private boolean phonePatternCheck(String phoneNumber) {
        Pattern p = Pattern.compile("^[0-9]{10}$");
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }
    
    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = ordersJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showConfirmDialog(null, "Please select a row from table to Assign Request.!","Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else{
            
            WorkRequest wr = (WorkRequest)ordersJTable.getValueAt(selectedRow, 0);
            if(wr instanceof VolunteerInventoryWorkRequest){
                VolunteerInventoryWorkRequest request = (VolunteerInventoryWorkRequest) wr;
                
               
                Date pickDate = pickUpDate.getDate();
                if(pickDate == null || pickDate.equals("")){ 
                    JOptionPane.showMessageDialog(null, "Pick Up Date can't be empty!");
                    return;
                }
                if(pickDate.before(new Date())){ 
                    JOptionPane.showMessageDialog(null, "Pick Up Date can't be in past.");
                    return;
                }
                
                request.setPickupDate(pickDate);

                Date deliverDate = deliveryDate.getDate();
                if(deliverDate == null || deliverDate.equals("")){ 
                    JOptionPane.showMessageDialog(null, "Delivery Date can't be empty!");
                    return;
                }
                if(deliverDate.before(new Date())){ 
                    JOptionPane.showMessageDialog(null, "Delivery Date can't be in past.");
                    return;
                }
                SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
                String deliverDateString = formatter.format(deliverDate);
                String pickUpDateString = formatter.format(pickDate);
                if(deliverDateString.compareTo(pickUpDateString)<0){ 
                    JOptionPane.showMessageDialog(null, "Delivery Date can't be before Pickup Date.");
                    return;
                }
                request.setExpectedDelivery(deliverDate);

                String contactNumber = contactjTextField.getText();
                if(contactNumber == null || contactNumber.equals("")){ 
                    JOptionPane.showMessageDialog(null, "Contact Number can't be empty!");
                    return;
                }
                if(!phonePatternCheck(contactNumber)){
                    JOptionPane.showMessageDialog(null, "Please enter a valid Contact Number", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                request.setDeliveryNumber(contactNumber);


                    request.setDelivery(userAccount);
                    userAccount.getWorkQueue().getWorkRequestList().add(request);
                    request.setStatus("Delivery Assigned");
                    contactjTextField.setText("");
                    senderAddress.setText("");
                    recieverAddress.setText("");
                    pickUpDate.setDate(null);
                    deliveryDate.setDate(null);
                    JOptionPane.showMessageDialog(null, "Delivery Request Assigned Successfully");

                    populateOrders();
                    populateAssignedOrders();
                }
                else {
                    HealthPharmacyWorkRequest request = (HealthPharmacyWorkRequest) wr;
                    Date pickDate = pickUpDate.getDate();
                if(pickDate == null || pickDate.equals("")){ 
                    JOptionPane.showMessageDialog(null, "Pick Up Date can't be empty!");
                    return;
                }
                request.setPickupDate(pickDate);

                Date deliverDate = deliveryDate.getDate();
                if(deliverDate == null || deliverDate.equals("")){ 
                    JOptionPane.showMessageDialog(null, "Delivery Date can't be empty!");
                    return;
                }
                request.setExpectedDelivery(deliverDate);

                String contactNumber = contactjTextField.getText();
                if(contactNumber == null || contactNumber.equals("")){ 
                    JOptionPane.showMessageDialog(null, "Contact Number can't be empty!");
                    return;
                }
                if(!phonePatternCheck(contactNumber)){
                    JOptionPane.showMessageDialog(null, "Please enter a valid Contact Number", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                request.setDeliveryNumber(contactNumber);


                request.setDelivery(userAccount);
                userAccount.getWorkQueue().getWorkRequestList().add(request);
                request.setStatus("Delivery Assigned");
                contactjTextField.setText("");
                senderAddress.setText("");
                recieverAddress.setText("");
                pickUpDate.setDate(null);
                deliveryDate.setDate(null);
                JOptionPane.showMessageDialog(null, "Delivery Request Assigned Successfully");

                populateOrders();
                populateAssignedOrders();
                }
           }
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void contactjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactjTextFieldActionPerformed

    private void ordersJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordersJTableMouseClicked
        
        int selectedRow = ordersJTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showConfirmDialog(null, "Please select a row from table to view details.!","Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            WorkRequest w = (WorkRequest) ordersJTable.getValueAt(selectedRow, 0);
            if(w instanceof VolunteerInventoryWorkRequest){
                VolunteerInventoryWorkRequest wr =(VolunteerInventoryWorkRequest) w;
                recieverAddress.setText(wr.getRecieverAddress());
                senderAddress.setText(wr.getSenderAddress());  
            }else{
                HealthPharmacyWorkRequest wr =(HealthPharmacyWorkRequest) w;
                senderAddress.setText(wr.getRecieverAddress());
                recieverAddress.setText(wr.getSenderAddress());  
            }
            
        }
    }//GEN-LAST:event_ordersJTableMouseClicked

    private void assignedJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assignedJTableMouseClicked
        int selectedRow = assignedJTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showConfirmDialog(null, "Please select a row from table to view details.!","Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
               
            WorkRequest w = (WorkRequest) assignedJTable.getValueAt(selectedRow, 0);
            if(w instanceof VolunteerInventoryWorkRequest){
                VolunteerInventoryWorkRequest wr = (VolunteerInventoryWorkRequest) w;
                recieverAdd.setText(wr.getRecieverAddress());
                reciever.setText(wr.getReceiver().getEmployee().getName());
                recieverContact.setText(wr.getRecieverNumber());
                senderAdd.setText(wr.getSenderAddress());  
                sender.setText(wr.getSender().getEmployee().getName());
                senderContact.setText(wr.getSenderNumber());
            }else{
                HealthPharmacyWorkRequest wr = (HealthPharmacyWorkRequest) w;
                senderAdd.setText(wr.getRecieverAddress());
                sender.setText(wr.getReceiver().getEmployee().getName());
                senderContact.setText(wr.getRecieverNumber());
                recieverAdd.setText(wr.getSenderAddress());  
                reciever.setText(wr.getSender().getEmployee().getName());
                recieverContact.setText(wr.getSenderNumber());
            }
            
            
        }
    }//GEN-LAST:event_assignedJTableMouseClicked

    private void deliverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliverButtonActionPerformed
        int selectedRow = assignedJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showConfirmDialog(null, "Please select a row from table to Assign Request!","Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else{

                WorkRequest w = (WorkRequest) assignedJTable.getValueAt(selectedRow, 0);
                if(w instanceof VolunteerInventoryWorkRequest){
                    VolunteerInventoryWorkRequest request = (VolunteerInventoryWorkRequest) w;

                    if(request.getStatus().equals("Delivered")){
                        JOptionPane.showMessageDialog(null, "Already Delivered!");
                        return;
                    }

                    request.setStatus("Delivered");
                    JOptionPane.showMessageDialog(null, "Status Updated Successfully.!");

                    populateAssignedOrders();
                    recieverAdd.setText("");
                    reciever.setText("");
                    recieverContact.setText("");
                    senderAdd.setText("");  
                    sender.setText("");
                    senderContact.setText("");
                
                } else{
                    
                    HealthPharmacyWorkRequest request = (HealthPharmacyWorkRequest) w;
                    
                    if(request.getStatus().equals("Delivered")){
                        JOptionPane.showMessageDialog(null, "Already Delivered!");
                        return;
                    }
                    
                    request.setStatus("Delivered");
                    JOptionPane.showMessageDialog(null, "Status Updated Successfully.!");
       
                    populateAssignedOrders();
                    recieverAdd.setText("");
                    reciever.setText("");
                    recieverContact.setText("");
                    senderAdd.setText("");  
                    sender.setText("");
                    senderContact.setText("");
                }
           }
    }//GEN-LAST:event_deliverButtonActionPerformed

    private void filterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterComboBoxActionPerformed

    private void filterComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterComboBoxMouseClicked
       
        
    }//GEN-LAST:event_filterComboBoxMouseClicked

    private void filterComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterComboBoxItemStateChanged
        String filter = (String) filterComboBox.getSelectedItem();
        
        if(filter.equals("All")){
            populateAssignedOrders();
        }
        
        if(filter.equals("Undelivered")){
            populateDeliveryAssignedOrders();
        }
        
        if(filter.equals("Delivered")){
            populateDeliveredOrders();
        }
        
        
        
    }//GEN-LAST:event_filterComboBoxItemStateChanged

    private void senderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JTable assignedJTable;
    private javax.swing.JTextField contactjTextField;
    private javax.swing.JButton deliverButton;
    private com.toedter.calendar.JDateChooser deliveryDate;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JComboBox filterComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable ordersJTable;
    private com.toedter.calendar.JDateChooser pickUpDate;
    private javax.swing.JTextField reciever;
    private javax.swing.JTextArea recieverAdd;
    private javax.swing.JTextArea recieverAddress;
    private javax.swing.JTextField recieverContact;
    private javax.swing.JTextField sender;
    private javax.swing.JTextArea senderAdd;
    private javax.swing.JTextArea senderAddress;
    private javax.swing.JTextField senderContact;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
