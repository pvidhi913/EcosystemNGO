/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.InventoryRole;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.EducationOrganization;
import Business.Organization.InventoryOrganization;
import Business.Organization.Organization;
import Business.Organization.TransportOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EducationVolunteerWorkRequest;
import Business.WorkQueue.VolunteerInventoryWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kashyap
 */
public class InventoryDepartmentWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form InventoryDepartmentWorkAreaJPanel
     */
    
    private JPanel userProcessContainer;
    private InventoryOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Network network;
    

    public InventoryDepartmentWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, InventoryOrganization organization, Enterprise enterprise, Network network) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = (InventoryOrganization)organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.network = network;
        valueLabel.setText(enterprise.getName());
        populateDonationsTable();
        populateOrdersTable();
    }
    
    public void populateDonationsTable(){
        DefaultTableModel model = (DefaultTableModel)tblDonations.getModel();
        
        model.setRowCount(0);
        
        for (Iterator<WorkRequest> it = organization.getWorkQueue().getWorkRequestList().iterator(); it.hasNext();) {
            VolunteerInventoryWorkRequest request = (VolunteerInventoryWorkRequest) it.next();
                if(request.getStatus().equalsIgnoreCase("Sent")){
                    Object[] row = new Object[4];
                    row[0]=request;
                    row[1] = request.getSender();
                    row[2]=request.getSenderNumber();
                    int sum=0;
                    for(Integer in: request.getQuantity())
                    {
                        sum=sum+in;
                    }
                    row[3]=sum;
                    model.addRow(row);
                }
                
        }
       
    }
    
    public void populateDetailsTable(ArrayList<String> category, ArrayList<Integer> quantity, ArrayList<String> description)
    {
        DefaultTableModel model = (DefaultTableModel) tblDetails.getModel();
        model.setRowCount(0);
                int len= category.size();
                for(int i=0;i<len;i++)
                {
                    Object[] row = new Object[3];
                    row[0] = category.get(i);
                    row[1] = quantity.get(i);
                    row[2] = description.get(i);
                    model.addRow(row);
                }
    }
    
    
    public void populateOrdersTable()
    {
        DefaultTableModel model = (DefaultTableModel) tblOrders.getModel();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy");
        model.setRowCount(0);
        for (Iterator<WorkRequest> it = userAccount.getWorkQueue().getWorkRequestList().iterator(); it.hasNext();) {
            WorkRequest wr= it.next();
            if(wr instanceof VolunteerInventoryWorkRequest)
            {
            VolunteerInventoryWorkRequest request = (VolunteerInventoryWorkRequest) wr;
            Object[] row = new Object[7];
            row[0] = request;
            row[1] = request.getStatus();
            row[2] = request.getSender();
            row[3] = request.getSenderNumber();
            
            if(request.getExpectedDelivery() ==null){
                row[6] = "";
            }else{
                Date date = request.getExpectedDelivery();
                String pickDate = formatter.format(date);
                row[6] = pickDate; 
            }
            
            if(request.getDelivery()==null){
                row[4] = "";
            }else{
                row[4] = request.getDelivery().getEmployee().getName();
            }
            row[5] = request.getDeliveryNumber();
            model.addRow(row);
            }
        }
        
    }
    
    
    public void populateDetails1Table(ArrayList<String> category, ArrayList<Integer> quantity, ArrayList<String> description)
    {
         DefaultTableModel model = (DefaultTableModel) tblDetails1.getModel();
        model.setRowCount(0);
                int len= category.size();
                for(int i=0;i<len;i++)
                {
                    Object[] row = new Object[3];
                    row[0] = category.get(i);
                    row[1] = quantity.get(i);
                    row[2] = description.get(i);
                    model.addRow(row);
                }
    }
    
    private boolean phonePatternCheck(String phoneNumber) {
        Pattern p = Pattern.compile("^[0-9]{10}$");
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
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
        NewDonationsJPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDonations = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDetails = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnOrderNow = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        MyOrdersJPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblDetails1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jTabbedPane1.setBackground(new java.awt.Color(180, 195, 195));
        jTabbedPane1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N

        NewDonationsJPanel.setBackground(new java.awt.Color(180, 195, 195));

        tblDonations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Donation ID", "Sender", "Number", "Total Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDonations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonationsMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblDonations);

        tblDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category", "Quantity", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblDetails);

        jLabel1.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        jLabel1.setText("Details");

        jLabel2.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        jLabel2.setText("Donations");

        btnOrderNow.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        btnOrderNow.setText("Order Now");
        btnOrderNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderNowActionPerformed(evt);
            }
        });

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtAddress.setRows(5);
        jScrollPane7.setViewportView(txtAddress);

        jLabel24.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Delivery Address:");

        jLabel11.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel11.setText("Contact Number:");

        txtNumber.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Inventory Work Area");

        enterpriseLabel.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        enterpriseLabel.setText("EnterPrise -");

        valueLabel.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        valueLabel.setText("<value>");

        javax.swing.GroupLayout NewDonationsJPanelLayout = new javax.swing.GroupLayout(NewDonationsJPanel);
        NewDonationsJPanel.setLayout(NewDonationsJPanelLayout);
        NewDonationsJPanelLayout.setHorizontalGroup(
            NewDonationsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
            .addGroup(NewDonationsJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(NewDonationsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewDonationsJPanelLayout.createSequentialGroup()
                        .addGroup(NewDonationsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(NewDonationsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOrderNow, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(NewDonationsJPanelLayout.createSequentialGroup()
                        .addGroup(NewDonationsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(NewDonationsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(NewDonationsJPanelLayout.createSequentialGroup()
                        .addComponent(enterpriseLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valueLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NewDonationsJPanelLayout.setVerticalGroup(
            NewDonationsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewDonationsJPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel25)
                .addGap(15, 15, 15)
                .addGroup(NewDonationsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(NewDonationsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NewDonationsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(NewDonationsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewDonationsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(26, 26, 26)
                .addComponent(btnOrderNow, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 312, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("New Donations", NewDonationsJPanel);

        MyOrdersJPanel.setBackground(new java.awt.Color(180, 195, 195));

        tblOrders.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Status", "Sender", "Sender Contact", "Delivery By", "Delivery Contact", "Delivery Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdersMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblOrders);
        if (tblOrders.getColumnModel().getColumnCount() > 0) {
            tblOrders.getColumnModel().getColumn(0).setResizable(false);
            tblOrders.getColumnModel().getColumn(1).setResizable(false);
            tblOrders.getColumnModel().getColumn(2).setResizable(false);
            tblOrders.getColumnModel().getColumn(3).setResizable(false);
            tblOrders.getColumnModel().getColumn(4).setResizable(false);
            tblOrders.getColumnModel().getColumn(5).setResizable(false);
            tblOrders.getColumnModel().getColumn(6).setResizable(false);
        }

        tblDetails1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        tblDetails1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category", "Quantity", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tblDetails1);

        jLabel3.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        jLabel3.setText("Order History");

        jLabel4.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        jLabel4.setText("Details");

        jLabel7.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Inventory Order History");

        javax.swing.GroupLayout MyOrdersJPanelLayout = new javax.swing.GroupLayout(MyOrdersJPanel);
        MyOrdersJPanel.setLayout(MyOrdersJPanelLayout);
        MyOrdersJPanelLayout.setHorizontalGroup(
            MyOrdersJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyOrdersJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MyOrdersJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(MyOrdersJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MyOrdersJPanelLayout.setVerticalGroup(
            MyOrdersJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyOrdersJPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addGap(45, 45, 45)
                .addGroup(MyOrdersJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MyOrdersJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(528, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("My Orders", MyOrdersJPanel);

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

    
    private void btnOrderNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderNowActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDonations.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showConfirmDialog(null, "Please select a row from table to Order.!","Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String address=txtAddress.getText();
        if(address==null || address.equals("")){
            JOptionPane.showMessageDialog(null,"Please enter Address !");
            return;
        }
        
        String contactNumber = txtNumber.getText();
                if(contactNumber == null || contactNumber.equals("")){ 
                JOptionPane.showMessageDialog(null, "Contact Number can't be empty!");
                return;
            }
        if(!phonePatternCheck(contactNumber)){
            JOptionPane.showMessageDialog(null, "Please enter a valid Contact Number", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        VolunteerInventoryWorkRequest request = (VolunteerInventoryWorkRequest)tblDonations.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setRecieverAddress(address);
        request.setRecieverNumber(contactNumber);
        request.setStatus("Ordered");
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        JOptionPane.showMessageDialog(null, "Order Placed Successfully. \n Your Order Id is "+request.getOrderID());
        
        populateOrdersTable();
        populateDonationsTable();
        DefaultTableModel model = (DefaultTableModel) tblDetails.getModel();
        model.setRowCount(0);
        DefaultTableModel model2 = (DefaultTableModel) tblDetails1.getModel();
        model2.setRowCount(0);
       
        for(Enterprise e: network.getEnterpriseDirectory().getEnterpriseList())
        {
            if(e.getEnterpriseType().equals(e.getEnterpriseType().Logistic))
            {
                for (Organization organization : e.getOrganizationDirectory().getOrganizationList())
                {
                    
                    if (organization instanceof TransportOrganization){
                        
                        organization.getWorkQueue().getWorkRequestList().add(request);
                    }
                }
            }
        }
        
        txtAddress.setText("");
        txtNumber.setText("");
    }//GEN-LAST:event_btnOrderNowActionPerformed

    private void tblOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdersMouseClicked
        // TODO add your handling code here:
        
        int selectedRow = tblOrders.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showConfirmDialog(null, "Please select a row from table to View Details!","Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else{
            VolunteerInventoryWorkRequest request = (VolunteerInventoryWorkRequest)tblOrders.getValueAt(selectedRow, 0);
            populateDetails1Table(request.getCategory(),request.getQuantity(),request.getDescription());
        }
    }//GEN-LAST:event_tblOrdersMouseClicked

    private void tblDonationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonationsMouseClicked
        int selectedRow = tblDonations.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showConfirmDialog(null, "Please select a row from table to View Details.!","Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            VolunteerInventoryWorkRequest request = (VolunteerInventoryWorkRequest)tblDonations.getValueAt(selectedRow, 0);
            
            populateDetailsTable(request.getCategory(),request.getQuantity(),request.getDescription());
        }
    }//GEN-LAST:event_tblDonationsMouseClicked

    private void txtNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MyOrdersJPanel;
    private javax.swing.JPanel NewDonationsJPanel;
    private javax.swing.JButton btnOrderNow;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDetails;
    private javax.swing.JTable tblDetails1;
    private javax.swing.JTable tblDonations;
    private javax.swing.JTable tblOrders;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
