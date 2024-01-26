/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PharmacistRole;

import UserInterface.DoctorRole.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.HealthOrganization;
import Business.Organization.Organization;
import Business.Organization.PharmacyOrganization;
import Business.Organization.TransportOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EducationVolunteerWorkRequest;
import Business.WorkQueue.HealthDoctorWorkRequest;
import Business.WorkQueue.HealthPharmacyWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
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
public class PharmacistWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private PharmacyOrganization pharmacyOrganization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Network network;
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public PharmacistWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, PharmacyOrganization organization,Network network, Enterprise enterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.pharmacyOrganization = (PharmacyOrganization)organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.network=network;
        populateAssignedTable();
        populateTable(); 
        populateDeliveryTable();
        valueLabel.setText(enterprise.getName());
       
    }
    
    public void populateAssignedTable() {
        DefaultTableModel model = (DefaultTableModel)assignedRequestJTable.getModel();
        model.setRowCount(0);   
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy");
        
        for (Iterator<WorkRequest> it = userAccount.getWorkQueue().getWorkRequestList().iterator(); it.hasNext();) {
             WorkRequest workRequest = it.next();
           if(workRequest instanceof HealthPharmacyWorkRequest){
                HealthPharmacyWorkRequest request = (HealthPharmacyWorkRequest)workRequest;
                Object[] row = new Object[6];
                row[0] = request;
                row[1]=request.getNgo();
                row[3]=request.getMedicineList();
                row[2]=request.getSender();
                row[4] = request.getRequestDate();
                row[5]=request.getStatus();
                model.addRow(row);
           }
           
        }
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel)tblMedicine.getModel();
        model.setRowCount(0);    
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy");
        
        for (Iterator<WorkRequest> it = pharmacyOrganization.getWorkQueue().getWorkRequestList().iterator(); it.hasNext();) {
            WorkRequest workRequest = it.next();
           if(workRequest instanceof HealthPharmacyWorkRequest){
               HealthPharmacyWorkRequest request = (HealthPharmacyWorkRequest) workRequest;
                if(request.getStatus().equalsIgnoreCase("sent"))
                {
                    Object[] row = new Object[5];
                    row[0] = request;
                    row[1]=request.getNgo();
                    row[3]=request.getMedicineList();
                    row[2]=request.getSender();
                    row[4] = request.getStatus();
                    model.addRow(row);
                }
               
           }
            
            
        }
    }
    
    
    public void populateDeliveryTable() {
        DefaultTableModel model = (DefaultTableModel)tblDelivery.getModel();
        model.setRowCount(0);    
        
        
        for (Iterator<WorkRequest> it = pharmacyOrganization.getWorkQueue().getWorkRequestList().iterator(); it.hasNext();) {
            WorkRequest workRequest = it.next();
           if(workRequest instanceof HealthPharmacyWorkRequest){
               HealthPharmacyWorkRequest request = (HealthPharmacyWorkRequest) workRequest;
                if(request.getStatus().equalsIgnoreCase("Delivery Requested") || request.getStatus().equalsIgnoreCase("Accepted") || request.getStatus().equalsIgnoreCase("Delivered") || request.getStatus().equalsIgnoreCase("Delivery Assigned") )
                {
                    Object[] row = new Object[5];
                    row[0] = request;
                    row[1]=request.getNgo();
                    row[3]=request.getMedicineList();
                    row[2]=request.getSender();
                    row[4] = request.getStatus();
                    model.addRow(row);
                }
               
           }
            
            
        }
    }
    
     public void populateRequested() {
        DefaultTableModel model = (DefaultTableModel)tblDelivery.getModel();
        model.setRowCount(0);    
        
        
        for (Iterator<WorkRequest> it = pharmacyOrganization.getWorkQueue().getWorkRequestList().iterator(); it.hasNext();) {
            WorkRequest workRequest = it.next();
           if(workRequest instanceof HealthPharmacyWorkRequest){
               HealthPharmacyWorkRequest request = (HealthPharmacyWorkRequest) workRequest;
                if(request.getStatus().equalsIgnoreCase("Delivery Requested") )
                {
                    Object[] row = new Object[5];
                    row[0] = request;
                    row[1]=request.getNgo();
                    row[3]=request.getMedicineList();
                    row[2]=request.getSender();
                    row[4] = request.getStatus();
                    model.addRow(row);
                }
               
           }
            
            
        }
    }
     
    public void populateUnRequested() {
        DefaultTableModel model = (DefaultTableModel)tblDelivery.getModel();
        model.setRowCount(0);    
        
        
        for (Iterator<WorkRequest> it = pharmacyOrganization.getWorkQueue().getWorkRequestList().iterator(); it.hasNext();) {
            WorkRequest workRequest = it.next();
           if(workRequest instanceof HealthPharmacyWorkRequest){
               HealthPharmacyWorkRequest request = (HealthPharmacyWorkRequest) workRequest;
                if(request.getStatus().equalsIgnoreCase("Accepted") )
                {
                    Object[] row = new Object[5];
                    row[0] = request;
                    row[1]=request.getNgo();
                    row[3]=request.getMedicineList();
                    row[2]=request.getSender();
                    row[4] = request.getStatus();
                    model.addRow(row);
                }
               
           }
            
            
        }
    }
    
    public void populateDelivered() {
        DefaultTableModel model = (DefaultTableModel)tblDelivery.getModel();
        model.setRowCount(0);    
        
        
        for (Iterator<WorkRequest> it = pharmacyOrganization.getWorkQueue().getWorkRequestList().iterator(); it.hasNext();) {
            WorkRequest workRequest = it.next();
           if(workRequest instanceof HealthPharmacyWorkRequest){
               HealthPharmacyWorkRequest request = (HealthPharmacyWorkRequest) workRequest;
                if(request.getStatus().equalsIgnoreCase("Delivered") )
                {
                    Object[] row = new Object[5];
                    row[0] = request;
                    row[1]=request.getNgo();
                    row[3]=request.getMedicineList();
                    row[2]=request.getSender();
                    row[4] = request.getStatus();
                    model.addRow(row);
                }
               
           }
            
            
        }
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
        homePageJPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        assignedRequestJTable = new javax.swing.JTable();
        refreshBtn = new javax.swing.JButton();
        processBtn = new javax.swing.JButton();
        btnMessage = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        newCasesJPanel = new javax.swing.JPanel();
        assignBtn = new javax.swing.JButton();
        refreshBtn1 = new javax.swing.JButton();
        btnMessage1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtMessage1 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMedicine = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDelivery = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        btnRequest = new javax.swing.JButton();
        refreshBtn2 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        filterComboBox = new javax.swing.JComboBox();
        txtNumber = new javax.swing.JTextField();

        jTabbedPane1.setBackground(new java.awt.Color(180, 195, 195));
        jTabbedPane1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N

        homePageJPanel.setBackground(new java.awt.Color(180, 195, 195));

        assignedRequestJTable.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        assignedRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NGO", "Sender", "Medicine List", "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        assignedRequestJTable.setPreferredSize(new java.awt.Dimension(375, 64));
        jScrollPane1.setViewportView(assignedRequestJTable);

        refreshBtn.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        processBtn.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        processBtn.setText("Process");
        processBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processBtnActionPerformed(evt);
            }
        });

        btnMessage.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnMessage.setText("View Medicine List");
        btnMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageActionPerformed(evt);
            }
        });

        txtMessage.setColumns(20);
        txtMessage.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtMessage.setRows(5);
        jScrollPane3.setViewportView(txtMessage);

        jLabel11.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Pharmacist Work Area");

        enterpriseLabel.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        enterpriseLabel.setText("EnterPrise -");

        valueLabel.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        valueLabel.setText("<value>");

        javax.swing.GroupLayout homePageJPanelLayout = new javax.swing.GroupLayout(homePageJPanel);
        homePageJPanel.setLayout(homePageJPanelLayout);
        homePageJPanelLayout.setHorizontalGroup(
            homePageJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePageJPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(enterpriseLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valueLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(homePageJPanelLayout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addGroup(homePageJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePageJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(homePageJPanelLayout.createSequentialGroup()
                            .addComponent(processBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMessage))
                        .addGroup(homePageJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(refreshBtn)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(215, Short.MAX_VALUE))
        );
        homePageJPanelLayout.setVerticalGroup(
            homePageJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePageJPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel11)
                .addGap(15, 15, 15)
                .addGroup(homePageJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(refreshBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(homePageJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(processBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(449, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Home Page", homePageJPanel);

        newCasesJPanel.setBackground(new java.awt.Color(180, 195, 195));

        assignBtn.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        assignBtn.setText("Assign to me");
        assignBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignBtnActionPerformed(evt);
            }
        });

        refreshBtn1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        refreshBtn1.setText("Refresh");
        refreshBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtn1ActionPerformed(evt);
            }
        });

        btnMessage1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnMessage1.setText("View Medicine List");
        btnMessage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessage1ActionPerformed(evt);
            }
        });

        txtMessage1.setColumns(20);
        txtMessage1.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtMessage1.setRows(5);
        jScrollPane4.setViewportView(txtMessage1);

        tblMedicine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NGO", "Sender", "Medicine List", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblMedicine);
        if (tblMedicine.getColumnModel().getColumnCount() > 0) {
            tblMedicine.getColumnModel().getColumn(3).setHeaderValue("Medicine List");
        }

        jLabel25.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("New Medicine Requests");

        javax.swing.GroupLayout newCasesJPanelLayout = new javax.swing.GroupLayout(newCasesJPanel);
        newCasesJPanel.setLayout(newCasesJPanelLayout);
        newCasesJPanelLayout.setHorizontalGroup(
            newCasesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(newCasesJPanelLayout.createSequentialGroup()
                .addContainerGap(213, Short.MAX_VALUE)
                .addGroup(newCasesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newCasesJPanelLayout.createSequentialGroup()
                        .addGap(650, 650, 650)
                        .addComponent(refreshBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(newCasesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(newCasesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(newCasesJPanelLayout.createSequentialGroup()
                                .addComponent(assignBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMessage1))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        newCasesJPanelLayout.setVerticalGroup(
            newCasesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newCasesJPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel25)
                .addGap(30, 30, 30)
                .addComponent(refreshBtn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(newCasesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMessage1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assignBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(493, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("New Requests", newCasesJPanel);

        jPanel1.setBackground(new java.awt.Color(180, 195, 195));

        tblDelivery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NGO", "Sender", "Medicine List", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblDelivery);
        if (tblDelivery.getColumnModel().getColumnCount() > 0) {
            tblDelivery.getColumnModel().getColumn(3).setHeaderValue("Medicine List");
        }

        jLabel24.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Delivery Address:");

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtAddress.setRows(5);
        jScrollPane7.setViewportView(txtAddress);

        jLabel12.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel12.setText("Contact Number:");

        btnRequest.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        btnRequest.setText("Request Delivery");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        refreshBtn2.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        refreshBtn2.setText("Refresh");
        refreshBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtn2ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("New Medicine Requests");

        jLabel13.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        jLabel13.setText("Filter By: ");

        jLabel14.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel14.setText("Status");

        filterComboBox.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        filterComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Requested", "UnRequested", "Delivered"}));
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

        txtNumber.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(251, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(refreshBtn2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel24)
                                .addComponent(jLabel12))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(322, 322, 322))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel14)))))
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(188, Short.MAX_VALUE))
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel26)
                .addGap(30, 30, 30)
                .addComponent(refreshBtn2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(30, 30, 30)
                        .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(443, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Delivery", jPanel1);

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

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        populateAssignedTable();
        txtMessage.setText("");   
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void processBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processBtnActionPerformed

        int selectedRow = assignedRequestJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
            return;
        }

        HealthPharmacyWorkRequest request = (HealthPharmacyWorkRequest)assignedRequestJTable.getValueAt(selectedRow, 0);
        if(request.getStatus().equalsIgnoreCase("Accepted")){
            JOptionPane.showMessageDialog(null, "Accepted request can't be processed.");
            return;
        }
        request.setStatus("Processing");
        
        ProcessMedicineRequestJPanel processWorkRequestJPanel = new ProcessMedicineRequestJPanel(userProcessContainer,enterprise, userAccount, request);
        userProcessContainer.add("ProcessMedicineRequestJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_processBtnActionPerformed

    private void assignBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignBtnActionPerformed
        // TODO add your handling code here:
         int selectedRow = tblMedicine.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
            return;
        }

        HealthPharmacyWorkRequest request = (HealthPharmacyWorkRequest)tblMedicine.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Assigned");
        System.out.println(userAccount);
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        JOptionPane.showMessageDialog(null, "Medicine Request Assigned Successfully");
        populateAssignedTable();
        populateTable();

    }//GEN-LAST:event_assignBtnActionPerformed

    private void refreshBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtn1ActionPerformed
        // TODO add your handling code here:
        populateTable(); 
        txtMessage1.setText("");

    }//GEN-LAST:event_refreshBtn1ActionPerformed

    private void btnMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageActionPerformed
        // TODO add your handling code here:
       
        int selectedRow = assignedRequestJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
            return;
        }
        HealthPharmacyWorkRequest request = (HealthPharmacyWorkRequest)assignedRequestJTable.getValueAt(selectedRow, 0);
        txtMessage.setText(request.getMedicineList()+"");
        txtMessage.setEditable(false);   

    }//GEN-LAST:event_btnMessageActionPerformed

    private void btnMessage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessage1ActionPerformed
        // TODO add your handling code here:
       int selectedRow = tblMedicine.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
            return;
        }
        HealthPharmacyWorkRequest request = (HealthPharmacyWorkRequest)tblMedicine.getValueAt(selectedRow, 0);
        txtMessage1.setText(request.getMedicineList()+"");
        txtMessage1.setEditable(false);

        
    }//GEN-LAST:event_btnMessage1ActionPerformed

    
    
     private boolean phonePatternCheck(String phoneNumber) {
        Pattern p = Pattern.compile("^[0-9]{10}$");
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }
     
    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDelivery.getSelectedRow();

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
        
        HealthPharmacyWorkRequest request = (HealthPharmacyWorkRequest)tblDelivery.getValueAt(selectedRow, 0);
        
        request.setRecieverAddress(address);
        request.setRecieverNumber(contactNumber);
        request.setStatus("Delivery Requested");
        JOptionPane.showMessageDialog(null, "Order Placed Successfully. \n Your Order Id is "+request.getId());
        
        populateDeliveryTable();

        Organization org = null;

        for(Enterprise e: network.getEnterpriseDirectory().getEnterpriseList())
        {
            if(e.getEnterpriseType().equals(e.getEnterpriseType().Logistic))
            {
                for (Organization organization : e.getOrganizationDirectory().getOrganizationList())
                {

                    if (organization instanceof TransportOrganization){
                        org = organization;
                        org.getWorkQueue().getWorkRequestList().add(request);
                    }
                }
            }
        }
        
        txtAddress.setText("");
        txtNumber.setText("");

    }//GEN-LAST:event_btnRequestActionPerformed

    private void refreshBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtn2ActionPerformed
        populateDeliveryTable();
        txtAddress.setText("");
        txtNumber.setText("");
    }//GEN-LAST:event_refreshBtn2ActionPerformed

    private void filterComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterComboBoxItemStateChanged
        String filter = (String) filterComboBox.getSelectedItem();

        if(filter.equals("All")){
            populateDeliveryTable();
        }

        if(filter.equals("Requested")){
            populateRequested();
        }

        if(filter.equals("UnRequested")){
            populateUnRequested();
        }
        if(filter.equals("Delivered")){
            populateDelivered();
        }
        

    }//GEN-LAST:event_filterComboBoxItemStateChanged

    private void filterComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterComboBoxMouseClicked

    }//GEN-LAST:event_filterComboBoxMouseClicked

    private void filterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignBtn;
    private javax.swing.JTable assignedRequestJTable;
    private javax.swing.JButton btnMessage;
    private javax.swing.JButton btnMessage1;
    private javax.swing.JButton btnRequest;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JComboBox filterComboBox;
    private javax.swing.JPanel homePageJPanel;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel newCasesJPanel;
    private javax.swing.JButton processBtn;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton refreshBtn1;
    private javax.swing.JButton refreshBtn2;
    private javax.swing.JTable tblDelivery;
    private javax.swing.JTable tblMedicine;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JTextArea txtMessage1;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables

   
}
