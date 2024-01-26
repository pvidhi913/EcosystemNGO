/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.VolunteerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.InventoryOrganization;
import Business.Organization.Organization;
import Business.Organization.VolunteerOrganization;
import Business.Role.VolunteerRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EducationVolunteerWorkRequest;
import Business.WorkQueue.VolunteerInventoryWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import UserInterface.HealthRole.RequestDoctorJPanel;
import UserInterface.SystemAdminWorkArea.ManageEnterpriseAdminJPanel;

/**
 *
 * @author vaibhaveegamit
 */
public class VolunteerWorkAreaJPanel extends javax.swing.JPanel {
    /**
     * Creates new form VolunteerWorkAreaJPanel
     */
    
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private VolunteerOrganization volunteerOrganization;
    private VolunteerRole volunteerRole;
    private Network network;
    private ArrayList<String> categoryList;
    private ArrayList<Integer> quantityList;
    private ArrayList<String> descriptionList;
    
    public VolunteerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization,  EcoSystem business, Enterprise enterprise, Network network) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.enterprise = enterprise;
        this.volunteerRole = volunteerRole;
        this.volunteerOrganization = (VolunteerOrganization)organization;
        this.network=network;
        categoryList= new ArrayList();
        quantityList=new ArrayList();
        descriptionList = new ArrayList();
        valueLabel.setText(enterprise.getName());
        populateAssignedTable();
        populateTable(); 
        populateUserDetails();
        
    }
    
    public void populateAssignedTable(){
        DefaultTableModel model = (DefaultTableModel)assignedRequestsJTable.getModel();
        
        model.setRowCount(0);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy");
        
        for (Iterator<WorkRequest> it = userAccount.getWorkQueue().getWorkRequestList().iterator(); it.hasNext();) {
            WorkRequest workRequest = it.next();
            if(workRequest instanceof EducationVolunteerWorkRequest){
                EducationVolunteerWorkRequest request = (EducationVolunteerWorkRequest) workRequest;

                for (Iterator<WorkRequest> cmp = volunteerOrganization.getWorkQueue().getWorkRequestList().iterator(); cmp.hasNext();) {
                    EducationVolunteerWorkRequest compare = (EducationVolunteerWorkRequest) cmp.next();

                    if(request == compare){
                        Object[] row = new Object[5];
                        row[0] = request;
                        Date date = request.getDate();
                        String volDate = formatter.format(date);
                        row[1] = volDate;
                        row[2] = request.getTime();
                        row[3] = request.getArea();
                        row[4] = request.getNumberOfVolunteers();
                        model.addRow(row);   
                    }   
                }   
            }
        }
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)newTasksJTable.getModel();
        
        model.setRowCount(0);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy");
        
        for (Iterator<WorkRequest> it = volunteerOrganization.getWorkQueue().getWorkRequestList().iterator(); it.hasNext();) {
            WorkRequest workRequest = it.next();
            if(workRequest instanceof EducationVolunteerWorkRequest){
                EducationVolunteerWorkRequest request = (EducationVolunteerWorkRequest) workRequest;
                if(request.getCurrentVacancy() > 0){
                    Object[] row = new Object[5];
                    row[0] = request;
                    Date date = request.getDate();
                    String volDate = formatter.format(date);
                    row[1] = volDate;
                    row[2] = request.getTime();
                    row[3] = request.getArea();
                    row[4] = request.getCurrentVacancy();
                    model.addRow(row);
                }     
            }
        }
    }
    
    
    public void populateUserDetails(){
  
        nameTextJField.setText(userAccount.getEmployee().getName());
        sexTextJField.setText(userAccount.getEmployee().getGender());

        LocalDate now = LocalDate.now();
        LocalDate birthdate = userAccount.getEmployee().getBirthDate();
        int age = userAccount.getEmployee().calculateAge(birthdate, now);
        ageTextJField.setText(String.valueOf(age));

        ageTextJField.setText(String.valueOf(age));
        nationalityTextJField.setText(userAccount.getEmployee().getNationality());
        emailIdTextJField.setText(userAccount.getEmployee().getEmailID());
        contactTextJField.setText(userAccount.getEmployee().getContactNumber());
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

        VolunteerJTabbedPane = new javax.swing.JTabbedPane();
        HomePageJPanel = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        leftJPanel = new javax.swing.JPanel();
        ageTextJField = new javax.swing.JTextField();
        updateDetailsJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nameTextJField = new javax.swing.JTextField();
        sexTextJField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nationalityTextJField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emailIdTextJField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        contactTextJField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnHistory = new javax.swing.JButton();
        rightJPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        assignedRequestsJTable = new javax.swing.JTable();
        refreshTestJButton2 = new javax.swing.JButton();
        jobTitleJTextField1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        placeJTextField1 = new javax.swing.JTextField();
        numberOfStudentsJTextField1 = new javax.swing.JTextField();
        numberOfHoursJTextField1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        numberOfVolunteersJTextField1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        volunteeringDate1 = new com.toedter.calendar.JDateChooser();
        Date date = new Date();
        SpinnerDateModel sm1 = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        volunteeringTime1 = new javax.swing.JSpinner(sm1);
        cancelJButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        requirementsJTextArea = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        areaJTextField1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        TasksJPanel = new javax.swing.JPanel();
        numberOfVolunteersJTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        numberOfHoursJTextField = new javax.swing.JTextField();
        volunteeringDate = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        volunteeringTime = new javax.swing.JSpinner(sm);
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jobTitleJTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        newTasksJTable = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        placeJTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        numberOfStudentsJTextField = new javax.swing.JTextField();
        refreshTestJButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        requirementsJTextArea1 = new javax.swing.JTextArea();
        assignJButton = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        areaJTextField = new javax.swing.JTextField();
        DonateJPanel = new javax.swing.JPanel();
        txtQuantity = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDonate = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        btnDonate = new javax.swing.JButton();
        selectCategory = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnUpdate = new javax.swing.JButton();
        txtNumber = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();

        VolunteerJTabbedPane.setBackground(new java.awt.Color(180, 195, 195));
        VolunteerJTabbedPane.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        VolunteerJTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                VolunteerJTabbedPaneStateChanged(evt);
            }
        });

        HomePageJPanel.setLayout(new java.awt.BorderLayout());

        leftJPanel.setBackground(new java.awt.Color(180, 195, 195));
        leftJPanel.setToolTipText("");

        ageTextJField.setEditable(false);
        ageTextJField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        updateDetailsJButton.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        updateDetailsJButton.setText("Update Details");
        updateDetailsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDetailsJButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel4.setText("Nationality:");

        nameTextJField.setEditable(false);
        nameTextJField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        sexTextJField.setEditable(false);
        sexTextJField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel2.setText("Sex: ");

        nationalityTextJField.setEditable(false);
        nationalityTextJField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        nationalityTextJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nationalityTextJFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel5.setText("Email Id:");

        emailIdTextJField.setEditable(false);
        emailIdTextJField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        emailIdTextJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailIdTextJFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel6.setText("Contact Number:");

        contactTextJField.setEditable(false);
        contactTextJField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        contactTextJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactTextJFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel1.setText("Name: ");

        jLabel3.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel3.setText("Age:");

        enterpriseLabel.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        enterpriseLabel.setText("EnterPrise -");

        valueLabel.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 16)); // NOI18N
        valueLabel.setText("<value>");

        jLabel24.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 20)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Volunteer Details");

        btnHistory.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnHistory.setText("Donation History");
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftJPanelLayout = new javax.swing.GroupLayout(leftJPanel);
        leftJPanel.setLayout(leftJPanelLayout);
        leftJPanelLayout.setHorizontalGroup(
            leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(updateDetailsJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                .addGap(84, 84, 84))
            .addGroup(leftJPanelLayout.createSequentialGroup()
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftJPanelLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(enterpriseLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valueLabel))
                    .addGroup(leftJPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(contactTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailIdTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nationalityTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ageTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        leftJPanelLayout.setVerticalGroup(
            leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftJPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueLabel)
                    .addComponent(enterpriseLabel))
                .addGap(30, 30, 30)
                .addComponent(jLabel24)
                .addGap(30, 30, 30)
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sexTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ageTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nationalityTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(emailIdTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(contactTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addComponent(updateDetailsJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(416, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(leftJPanel);

        rightJPanel.setBackground(new java.awt.Color(180, 195, 195));

        assignedRequestsJTable.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        assignedRequestsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Job Title", "Date", "Time", "Area", "Total Volunteers"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        assignedRequestsJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                assignedRequestsJTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(assignedRequestsJTable);

        refreshTestJButton2.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        refreshTestJButton2.setText("Refresh");
        refreshTestJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButton2ActionPerformed(evt);
            }
        });

        jobTitleJTextField1.setEditable(false);
        jobTitleJTextField1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Job Title:");

        jLabel19.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel19.setText("Date:");

        jLabel20.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel20.setText("Time: ");

        jLabel9.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Place:");

        placeJTextField1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N

        numberOfStudentsJTextField1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N

        numberOfHoursJTextField1.setEditable(false);
        numberOfHoursJTextField1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        numberOfHoursJTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfHoursJTextField1ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Number of Hours:");

        jLabel10.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Number of Students:");

        jLabel22.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Number of Volunteers:");

        numberOfVolunteersJTextField1.setEditable(false);
        numberOfVolunteersJTextField1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Requirements:");

        volunteeringDate1.setEnabled(false);
        volunteeringDate1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N

        cancelJButton.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        cancelJButton.setText("Cancel Request");
        cancelJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelJButtonActionPerformed(evt);
            }
        });

        requirementsJTextArea.setColumns(20);
        requirementsJTextArea.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        requirementsJTextArea.setRows(5);
        jScrollPane3.setViewportView(requirementsJTextArea);

        jLabel11.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 22)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Volunteer Work Area");

        jLabel27.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Area:");

        areaJTextField1.setEditable(false);
        areaJTextField1.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        jLabel28.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 15)); // NOI18N
        jLabel28.setText("My Tasks");

        javax.swing.GroupLayout rightJPanelLayout = new javax.swing.GroupLayout(rightJPanel);
        rightJPanel.setLayout(rightJPanelLayout);
        rightJPanelLayout.setHorizontalGroup(
            rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(rightJPanelLayout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(rightJPanelLayout.createSequentialGroup()
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(refreshTestJButton2))
                        .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancelJButton)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rightJPanelLayout.createSequentialGroup()
                        .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rightJPanelLayout.createSequentialGroup()
                                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightJPanelLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(31, 31, 31)))
                        .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(numberOfVolunteersJTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(numberOfHoursJTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(numberOfStudentsJTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(placeJTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(volunteeringTime1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(volunteeringDate1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jobTitleJTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(areaJTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        rightJPanelLayout.setVerticalGroup(
            rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightJPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addGap(15, 15, 15)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(refreshTestJButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jobTitleJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightJPanelLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(22, 22, 22)
                        .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(volunteeringTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(placeJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(volunteeringDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(17, 17, 17)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfStudentsJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfHoursJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(numberOfVolunteersJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        JSpinner.DateEditor de1 = new JSpinner.DateEditor(volunteeringTime1, "HH:mm");
        volunteeringTime1.setEditor(de1);
        volunteeringTime1.setEnabled(false);

        jSplitPane1.setRightComponent(rightJPanel);

        HomePageJPanel.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        VolunteerJTabbedPane.addTab("Home Page", HomePageJPanel);

        TasksJPanel.setBackground(new java.awt.Color(180, 195, 195));

        numberOfVolunteersJTextField.setEditable(false);
        numberOfVolunteersJTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Number of Volunteers:");

        numberOfHoursJTextField.setEditable(false);
        numberOfHoursJTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        numberOfHoursJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfHoursJTextFieldActionPerformed(evt);
            }
        });

        volunteeringDate.setEnabled(false);
        volunteeringDate.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel14.setText("Time: ");

        jLabel13.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel13.setText("Date:");

        JSpinner.DateEditor de = new JSpinner.DateEditor(volunteeringTime, "HH:mm");
        volunteeringTime.setEditor(de);
        volunteeringTime.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        volunteeringTime.setEnabled(false);

        jLabel17.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Requirements:");

        jLabel12.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Job Title:");

        jobTitleJTextField.setEditable(false);
        jobTitleJTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        newTasksJTable.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        newTasksJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Job Title", "Date", "Time", "Area", "Current Vacancy"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        newTasksJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newTasksJTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(newTasksJTable);

        jLabel15.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Number of Hours:");

        placeJTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Place:");

        jLabel8.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Number of Students:");

        numberOfStudentsJTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        refreshTestJButton3.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        refreshTestJButton3.setText("Refresh");
        refreshTestJButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButton3ActionPerformed(evt);
            }
        });

        requirementsJTextArea1.setColumns(20);
        requirementsJTextArea1.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        requirementsJTextArea1.setRows(5);
        jScrollPane4.setViewportView(requirementsJTextArea1);

        assignJButton.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 22)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("New Volunteer Requests");

        jLabel26.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Area:");

        areaJTextField.setEditable(false);
        areaJTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        areaJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaJTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TasksJPanelLayout = new javax.swing.GroupLayout(TasksJPanel);
        TasksJPanel.setLayout(TasksJPanelLayout);
        TasksJPanelLayout.setHorizontalGroup(
            TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TasksJPanelLayout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(numberOfVolunteersJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(numberOfHoursJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(areaJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(volunteeringTime, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(volunteeringDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addComponent(jobTitleJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(placeJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(numberOfStudentsJTextField, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(439, 439, 439))
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(TasksJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(assignJButton)
                    .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(refreshTestJButton3)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        TasksJPanelLayout.setVerticalGroup(
            TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TasksJPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel25)
                .addGap(10, 10, 10)
                .addComponent(refreshTestJButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(assignJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jobTitleJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(volunteeringDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(volunteeringTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(placeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(11, 11, 11)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfStudentsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfHoursJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(numberOfVolunteersJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(221, Short.MAX_VALUE))
        );

        VolunteerJTabbedPane.addTab("New Tasks", TasksJPanel);

        DonateJPanel.setBackground(new java.awt.Color(180, 195, 195));
        DonateJPanel.setPreferredSize(new java.awt.Dimension(3043, 1021));

        txtQuantity.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        tblDonate.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        tblDonate.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tblDonate);

        btnAdd.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnModify.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnModify.setText("Modify");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Pickup Address:");

        jLabel30.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel30.setText("Category:");

        jLabel31.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel31.setText("Quantity:");

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtAddress.setRows(5);
        jScrollPane6.setViewportView(txtAddress);

        btnDonate.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnDonate.setText("DONATE");
        btnDonate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonateActionPerformed(evt);
            }
        });

        selectCategory.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        selectCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Books", "Toys", "Clothes", "Other" }));

        jLabel32.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel32.setText("Description:");

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        txtDescription.setRows(5);
        jScrollPane7.setViewportView(txtDescription);

        btnUpdate.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtNumber.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        jLabel33.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel33.setText("Mobile Number:");

        jLabel34.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 22)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Donate Work Requests");

        javax.swing.GroupLayout DonateJPanelLayout = new javax.swing.GroupLayout(DonateJPanel);
        DonateJPanel.setLayout(DonateJPanelLayout);
        DonateJPanelLayout.setHorizontalGroup(
            DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DonateJPanelLayout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DonateJPanelLayout.createSequentialGroup()
                        .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel29))
                        .addGap(18, 18, 18)
                        .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDonate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DonateJPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DonateJPanelLayout.createSequentialGroup()
                                .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(selectCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(DonateJPanelLayout.createSequentialGroup()
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DonateJPanelLayout.createSequentialGroup()
                .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        DonateJPanelLayout.setVerticalGroup(
            DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DonateJPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel34)
                .addGap(50, 50, 50)
                .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DonateJPanelLayout.createSequentialGroup()
                        .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(selectCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DonateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDonate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
        );

        VolunteerJTabbedPane.addTab("Donate", DonateJPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VolunteerJTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1113, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VolunteerJTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void VolunteerJTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_VolunteerJTabbedPaneStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_VolunteerJTabbedPaneStateChanged

    private void numberOfHoursJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfHoursJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberOfHoursJTextFieldActionPerformed

    private void contactTextJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactTextJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactTextJFieldActionPerformed

    private void emailIdTextJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailIdTextJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailIdTextJFieldActionPerformed

    private void nationalityTextJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nationalityTextJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nationalityTextJFieldActionPerformed

    private void updateDetailsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDetailsJButtonActionPerformed
        UpdateVolunteerDetailsJPanel manageEnterpriseAdminJPanel=new UpdateVolunteerDetailsJPanel(userProcessContainer,userAccount);
        userProcessContainer.add("manageEnterpriseAdminJPanel",manageEnterpriseAdminJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_updateDetailsJButtonActionPerformed

    private void refreshTestJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButton2ActionPerformed

        populateAssignedTable();

    }//GEN-LAST:event_refreshTestJButton2ActionPerformed

    private void numberOfHoursJTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfHoursJTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberOfHoursJTextField1ActionPerformed

    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJButtonActionPerformed
        
        int selectedRow = assignedRequestsJTable.getSelectedRow();
        if(selectedRow>=0){
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to Cancel this request??","Warning",selectionButton);
            if(selectionResult == JOptionPane.YES_OPTION){
                EducationVolunteerWorkRequest request = (EducationVolunteerWorkRequest) assignedRequestsJTable.getValueAt(selectedRow, 0);
                
                if(request.getDate().before(new Date())){
                    JOptionPane.showMessageDialog(null, "Request can't be cancelled, since request has past date.");
                }
                
                userAccount.getWorkQueue().getWorkRequestList().remove(request);
                request.getUsersList().remove(userAccount);
                int currentVac = request.getCurrentVacancy();
                request.setCurrentVacancy(currentVac + 1);

                populateTable();
                populateAssignedTable(); 
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
        }
    }//GEN-LAST:event_cancelJButtonActionPerformed

    private void refreshTestJButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButton3ActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshTestJButton3ActionPerformed

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed
        
         int selectedRow = newTasksJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showConfirmDialog(null, "Please select a row from table to Assign Request!","Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else{

            EducationVolunteerWorkRequest request = (EducationVolunteerWorkRequest)newTasksJTable.getValueAt(selectedRow, 0);

            boolean isAlreadyAssigned = userAccount.checkDuplicates(request);

            if(isAlreadyAssigned == true){
                JOptionPane.showMessageDialog(null, "Volunteer Request Already Assigned.");
                return;
            }
            
            List<WorkRequest> requestList = new ArrayList<WorkRequest>();
            requestList = userAccount.getWorkQueue().getWorkRequestList();
            
            for(WorkRequest r: requestList){
                if(r instanceof EducationVolunteerWorkRequest){
                    EducationVolunteerWorkRequest request1 = (EducationVolunteerWorkRequest)r;
                    SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy");
                    String request1Date = formatter.format(request1.getDate());
                    String requestDate = formatter.format(request.getDate());
                    if(request1Date.equals(requestDate)){
                        JOptionPane.showMessageDialog(null, "You already have a task on that day. Please select a task with another date.");
                        return;
                    }   
                }
            }

            if(isAlreadyAssigned == false){
                request.setReceiver(userAccount);
                int vacancy = request.getCurrentVacancy();
                request.setCurrentVacancy(vacancy-1);
                if(request.getCurrentVacancy()== 0){
                    request.setStatus("Completed");
                } else {
                    request.setStatus("Pending");
                }
                userAccount.getWorkQueue().getWorkRequestList().add(request);
                request.getUsersList().add(userAccount);
                JOptionPane.showMessageDialog(null, "Volunteer Request Assigned Successfully!"); 
            }
        }

        populateTable();
        populateAssignedTable();
        
        jobTitleJTextField.setText("");
        volunteeringDate.setDate(new Date());
        volunteeringTime.setValue("");
        numberOfHoursJTextField.setText("");
        numberOfVolunteersJTextField.setText("");
        requirementsJTextArea.setText("");
        placeJTextField.setText("");
        areaJTextField.setText("");
        numberOfStudentsJTextField1.setText("");
        
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void assignedRequestsJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assignedRequestsJTableMouseClicked
        
        int selectedRow = assignedRequestsJTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showConfirmDialog(null, "Please select a row from table to view details.!","Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            EducationVolunteerWorkRequest wr = (EducationVolunteerWorkRequest) assignedRequestsJTable.getValueAt(selectedRow, 0);
            jobTitleJTextField1.setText(wr.getJobTitle());
            volunteeringDate1.setDate(wr.getDate());

            Date time = null;
            String volTime = wr.getTime();
            SimpleDateFormat formatterDefault = new SimpleDateFormat("HH:mm");

            try {
                time = formatterDefault.parse(volTime);
            } catch (ParseException ex) {

            }

            volunteeringTime1.setValue(time);

            numberOfHoursJTextField1.setText(String.valueOf(wr.getNumberOfhours()));
            numberOfVolunteersJTextField1.setText(String.valueOf(wr.getNumberOfVolunteers()));
            requirementsJTextArea.setText(wr.getMessage());
            placeJTextField1.setText(wr.getPlace());
            areaJTextField1.setText(wr.getArea());
            numberOfStudentsJTextField1.setText(String.valueOf(wr.getNumberOfStudents()));
            
        }
    }//GEN-LAST:event_assignedRequestsJTableMouseClicked

    private void newTasksJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newTasksJTableMouseClicked
       int selectedRow = newTasksJTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showConfirmDialog(null, "Please select a row from table to View Details.!","Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            EducationVolunteerWorkRequest wr = (EducationVolunteerWorkRequest) newTasksJTable.getValueAt(selectedRow, 0);
            jobTitleJTextField.setText(wr.getJobTitle());
            volunteeringDate.setDate(wr.getDate());

            Date time = null;
            String volTime = wr.getTime();
            SimpleDateFormat formatterDefault = new SimpleDateFormat("HH:mm");

            try {
                time = formatterDefault.parse(volTime);
            } catch (ParseException ex) {

            }

            volunteeringTime.setValue(time);

            numberOfHoursJTextField.setText(String.valueOf(wr.getNumberOfhours()));
            numberOfVolunteersJTextField.setText(String.valueOf(wr.getNumberOfVolunteers()));
            requirementsJTextArea1.setText(wr.getMessage());
            placeJTextField.setText(wr.getPlace());
            areaJTextField.setText(wr.getArea());
            numberOfStudentsJTextField.setText(String.valueOf(wr.getNumberOfStudents()));

        }
    }//GEN-LAST:event_newTasksJTableMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
        String description="";
        
        String quantityText = txtQuantity.getText();
        if(quantityText==null || quantityText.equals("")){
            JOptionPane.showMessageDialog(null,"Please enter quantity !");
            return;
        }
        
        try{
            Integer.parseInt(txtQuantity.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please type in a number for Quantity");
            return;
        }
        int quantity = Integer.parseInt(quantityText);
        if(quantity<=0)
        {
            JOptionPane.showMessageDialog(null, "Quantity should be greater than zero !");
            return;
        }
        description = txtDescription.getText();
        
        
        String category= (String) selectCategory.getSelectedItem();
        categoryList.add(category);
        descriptionList.add(description);
        quantityList.add(quantity);
        populateDonateTable();
        
        txtQuantity.setText("");
        txtDescription.setText("");
        selectCategory.setSelectedIndex(0);
        

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDonate.getSelectedRow();
        if(selectedRow>=0){

                categoryList.remove(selectedRow);
                quantityList.remove(selectedRow);
                descriptionList.remove(selectedRow);
                populateDonateTable();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a row!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    
   
    private void btnDonateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonateActionPerformed
        
        if(categoryList.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please enter items to donate.");
            return;
        }
        
        String address = txtAddress.getText();
        if(address == null || address.equals("")){
            JOptionPane.showMessageDialog(null,"Please enter Address!");
            return;
        }
        
        String contactNumber = txtNumber.getText();
        if(contactNumber == null || contactNumber.equals("")){ 
            JOptionPane.showMessageDialog(null, "Contact Number can't be empty!");
            return;
        }
        
        if(!phonePatternCheck(contactNumber)){
            JOptionPane.showMessageDialog(null, "Please enter a valid Contact Number.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        VolunteerInventoryWorkRequest request = new VolunteerInventoryWorkRequest();
        
        
        for(String s: categoryList){
            request.getCategory().add(s);
        }
        
        for(String s: descriptionList){
            request.getDescription().add(s);
        }
        
        for(Integer s: quantityList){
            request.getQuantity().add(s);
        }
        
        request.setSenderAddress(address);
        request.setSenderNumber(contactNumber);
        request.setSender(userAccount);
        request.setStatus("Sent");
        
        Organization org=null;
        
        for(Enterprise e: network.getEnterpriseDirectory().getEnterpriseList())
        {
            if(e.getEnterpriseType().equals(e.getEnterpriseType().NGO))
            {
                for (Organization organization : e.getOrganizationDirectory().getOrganizationList())
                {
                    if (organization instanceof InventoryOrganization){
                        org = organization;
                        org.getWorkQueue().getWorkRequestList().add(request);
                    }
                }
            }
        }
        if (org!=null){
            userAccount.getWorkQueue().getWorkRequestList().add(request);
        } else {
            JOptionPane.showMessageDialog(null, "Donation Request Failed!");
            return;
        }
        
        categoryList.clear();
        quantityList.clear();
        descriptionList.clear();
        
        JOptionPane.showMessageDialog(null, "Donation Request Sent Successfully. Your OrderId is : " +request.getOrderID());
        populateDonateTable();
        txtQuantity.setText("");
        txtDescription.setText("");
        txtAddress.setText("");
        txtNumber.setText("");
        selectCategory.setSelectedIndex(0);
    }//GEN-LAST:event_btnDonateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDonate.getSelectedRow();
        
        String description="";
        
        String quantityText = txtQuantity.getText();
        if(quantityText==null || quantityText.equals("")){
            JOptionPane.showMessageDialog(null,"Please enter quantity !");
            return;
        }
        
        try {
            Integer.parseInt(txtQuantity.getText());
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please type in a number for Quantity");
            return;
        }
        int quantity = Integer.parseInt(quantityText);
        if(quantity<=0){
            JOptionPane.showMessageDialog(null, "Quantity should be greater than zero!");
            return;
        }
        description = txtDescription.getText();
       
        String category= (String) selectCategory.getSelectedItem();
        
        categoryList.set(selectedRow, category);
        quantityList.set(selectedRow, quantity);
        descriptionList.set(selectedRow, description);
        btnAdd.setEnabled(true);
        btnModify.setEnabled(true);
        btnUpdate.setEnabled(false);
        tblDonate.setEnabled(true);
        btnDelete.setEnabled(true);
        btnDonate.setEnabled(true);
        populateDonateTable();
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDonate.getSelectedRow();
        if(selectedRow >= 0){
            String c=categoryList.get(selectedRow);
            int q=quantityList.get(selectedRow);
            String d=descriptionList.get(selectedRow);
            selectCategory.setSelectedItem(c);
            txtQuantity.setText(String.valueOf(q));
            txtDescription.setText(d);
            btnAdd.setEnabled(false);
            btnModify.setEnabled(false);
            btnUpdate.setEnabled(true);
            tblDonate.setEnabled(false);
            btnDelete.setEnabled(false);
            btnDonate.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("OrderHistoryJPanel", new OrderHistoryJPanel(userProcessContainer, userAccount, enterprise));
        layout.next(userProcessContainer);    
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void areaJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaJTextFieldActionPerformed
    
    private void populateDonateTable() {
        DefaultTableModel model = (DefaultTableModel)tblDonate.getModel();
        model.setRowCount(0);
        int s=categoryList.size();
        for (int i=0;i<s;i++) {
                Object[] row = new Object[3];
                row[0] = categoryList.get(i);
                row[1] = quantityList.get(i);
                row[2] = descriptionList.get(i);
                model.addRow(row);    
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DonateJPanel;
    private javax.swing.JPanel HomePageJPanel;
    private javax.swing.JPanel TasksJPanel;
    private javax.swing.JTabbedPane VolunteerJTabbedPane;
    private javax.swing.JTextField ageTextJField;
    private javax.swing.JTextField areaJTextField;
    private javax.swing.JTextField areaJTextField1;
    private javax.swing.JButton assignJButton;
    private javax.swing.JTable assignedRequestsJTable;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDonate;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton cancelJButton;
    private javax.swing.JTextField contactTextJField;
    private javax.swing.JTextField emailIdTextJField;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jobTitleJTextField;
    private javax.swing.JTextField jobTitleJTextField1;
    private javax.swing.JPanel leftJPanel;
    private javax.swing.JTextField nameTextJField;
    private javax.swing.JTextField nationalityTextJField;
    private javax.swing.JTable newTasksJTable;
    private javax.swing.JTextField numberOfHoursJTextField;
    private javax.swing.JTextField numberOfHoursJTextField1;
    private javax.swing.JTextField numberOfStudentsJTextField;
    private javax.swing.JTextField numberOfStudentsJTextField1;
    private javax.swing.JTextField numberOfVolunteersJTextField;
    private javax.swing.JTextField numberOfVolunteersJTextField1;
    private javax.swing.JTextField placeJTextField;
    private javax.swing.JTextField placeJTextField1;
    private javax.swing.JButton refreshTestJButton2;
    private javax.swing.JButton refreshTestJButton3;
    private javax.swing.JTextArea requirementsJTextArea;
    private javax.swing.JTextArea requirementsJTextArea1;
    private javax.swing.JPanel rightJPanel;
    private javax.swing.JComboBox selectCategory;
    private javax.swing.JTextField sexTextJField;
    private javax.swing.JTable tblDonate;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JButton updateDetailsJButton;
    private javax.swing.JLabel valueLabel;
    private com.toedter.calendar.JDateChooser volunteeringDate;
    private com.toedter.calendar.JDateChooser volunteeringDate1;
    private javax.swing.JSpinner volunteeringTime;
    private javax.swing.JSpinner volunteeringTime1;
    // End of variables declaration//GEN-END:variables

    
}
