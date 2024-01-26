/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EducationRole;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.EducationVolunteerWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vidhi
 */
public class ViewVolunteersJPanel extends javax.swing.JPanel {

    
    private JPanel userProcessContainer;
    private EducationVolunteerWorkRequest request;
    /**
     * Creates new form ViewVolunteersJPanel
     */
    public ViewVolunteersJPanel(JPanel userProcessContainer, EducationVolunteerWorkRequest request) {
        
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        initComponents();
        populateVolunteerTable();
    }

    private void populateVolunteerTable(){
        
        DefaultTableModel model = (DefaultTableModel) volunteerListJTable.getModel();
       
        model.setRowCount(0);
        for (Iterator<UserAccount> it = request.getUsersList().iterator(); it.hasNext();) {
            UserAccount volunteer = (UserAccount) it.next();
            Object[] row = new Object[6];
            row[0] = volunteer;
            row[1] = volunteer.getEmployee().getGender();
            
             LocalDate now = LocalDate.now();
             LocalDate birthdate = volunteer.getEmployee().getBirthDate();
             int age = volunteer.getEmployee().calculateAge(birthdate, now);
             
            row[2] = age;
            row[3] = volunteer.getEmployee().getEmailID(); 
            row[4] = volunteer.getEmployee().getContactNumber();
            row[5] = volunteer.getEmployee().getNationality();
            model.addRow(row);
        }
    }
    
    private void populateBlankDetails(){
        nameTextJField.setText("");
        sexTextJField.setText("");
        ageTextJField.setText("");
        nationalityTextJField.setText("");
        emailIDTextJField.setText("");
        contactNumberTextJField.setText("");
        addressjTextArea1.setText("");
        cityTextJField.setText("");
        pincodeTextJField.setText("");
        skillsjTextArea.setText("");
        educationjTextArea.setText("");
        languageJTextField.setText("");
        languagejTextArea.setText("");
        wordjCheckBox.setSelected(false);
        exceljCheckBox.setSelected(false);
        pptjCheckBox.setSelected(false);
        webjCheckBox.setSelected(false);
        emailjCheckBox.setSelected(false); 
    }
    
    private void populateVolunteerDetails(UserAccount userAccount){
        
        nameTextJField.setText(userAccount.getEmployee().getName());
        sexTextJField.setText(userAccount.getEmployee().getGender());

        LocalDate now = LocalDate.now();
        LocalDate birthdate = userAccount.getEmployee().getBirthDate();
        int age = userAccount.getEmployee().calculateAge(birthdate, now);
        ageTextJField.setText(String.valueOf(age));

        ageTextJField.setText(String.valueOf(age));
        nationalityTextJField.setText(userAccount.getEmployee().getNationality());
        emailIDTextJField.setText(userAccount.getEmployee().getEmailID());
        contactNumberTextJField.setText(userAccount.getEmployee().getContactNumber());
        addressjTextArea1.setText(userAccount.getVolunteer().getAddress());
        cityTextJField.setText(userAccount.getVolunteer().getCity());
        pincodeTextJField.setText(userAccount.getVolunteer().getPinCode());
        skillsjTextArea.setText(userAccount.getVolunteer().getAdditionalSkills());
        languageJTextField.setText(userAccount.getVolunteer().getEnglishProficency());

        populateLang(userAccount);
        populateEducation(userAccount);

        if(userAccount.getVolunteer().getExpertiseList().contains("MS Word")){
            wordjCheckBox.setSelected(true);
        }
        if(userAccount.getVolunteer().getExpertiseList().contains("MS Excel")){
            exceljCheckBox.setSelected(true);
        }
        if(userAccount.getVolunteer().getExpertiseList().contains("PowerPoint")){
            pptjCheckBox.setSelected(true);
        }
        if(userAccount.getVolunteer().getExpertiseList().contains("Web Browsing")){
            webjCheckBox.setSelected(true);
        }
        if(userAccount.getVolunteer().getExpertiseList().contains("Email Checking")){
            emailjCheckBox.setSelected(true);
        }
        
    }
    
     private void populateLang(UserAccount userAccount){
        for(String lang: userAccount.getVolunteer().getLanguageList()){
                 languagejTextArea.append(lang + "\n");
        }
    }
    
    private void populateEducation(UserAccount userAccount){
        educationjTextArea.setText("");
        int count = 1;
        for(Map.Entry<String,String> entry : userAccount.getVolunteer().getEducationMap().entrySet()){
            educationjTextArea.append(count + ".  " + entry.getKey() + " " + entry.getValue() + "\n");
            count++;
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

        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        volunteerListJTable = new javax.swing.JTable();
        cancelRequestJButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        skillsjTextArea = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        webjCheckBox = new javax.swing.JCheckBox();
        emailjCheckBox = new javax.swing.JCheckBox();
        pptjCheckBox = new javax.swing.JCheckBox();
        exceljCheckBox = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        wordjCheckBox = new javax.swing.JCheckBox();
        languageJTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        languagejTextArea = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        educationjTextArea = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sexTextJField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ageTextJField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nameTextJField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nationalityTextJField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        emailIDTextJField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        contactNumberTextJField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        addressjTextArea1 = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        cityTextJField = new javax.swing.JTextField();
        pincodeTextJField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(180, 195, 195));

        btnBack.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        volunteerListJTable.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        volunteerListJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Gender", "Age", "Email ID", "Phone No.", "Nationality"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        volunteerListJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volunteerListJTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(volunteerListJTable);

        cancelRequestJButton.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        cancelRequestJButton.setText("Decline Request");
        cancelRequestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelRequestJButtonActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Volunteers Details");

        skillsjTextArea.setEditable(false);
        skillsjTextArea.setColumns(20);
        skillsjTextArea.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        skillsjTextArea.setRows(5);
        jScrollPane4.setViewportView(skillsjTextArea);

        jLabel20.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel20.setText("Work Knowledge of:");

        webjCheckBox.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        webjCheckBox.setText("Web Browsing");

        emailjCheckBox.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        emailjCheckBox.setText("Email Checking");

        pptjCheckBox.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        pptjCheckBox.setText("PowerPoint");

        exceljCheckBox.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        exceljCheckBox.setText("MS Excel");

        jLabel11.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 18)); // NOI18N
        jLabel11.setText("Education");

        wordjCheckBox.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        wordjCheckBox.setText("MS Word");
        wordjCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordjCheckBoxActionPerformed(evt);
            }
        });

        languageJTextField.setEditable(false);
        languageJTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        languageJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageJTextFieldActionPerformed(evt);
            }
        });

        languagejTextArea.setEditable(false);
        languagejTextArea.setColumns(20);
        languagejTextArea.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        languagejTextArea.setRows(5);
        jScrollPane3.setViewportView(languagejTextArea);

        jLabel19.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel19.setText("Other Language:");

        jLabel18.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("English: ");

        educationjTextArea.setEditable(false);
        educationjTextArea.setColumns(20);
        educationjTextArea.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        educationjTextArea.setRows(5);
        jScrollPane2.setViewportView(educationjTextArea);

        jLabel17.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 18)); // NOI18N
        jLabel17.setText("Language Proficency & Skills");

        jLabel21.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel21.setText("Skills:");

        jLabel2.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel2.setText("Sex: ");

        sexTextJField.setEditable(false);
        sexTextJField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel3.setText("Age:");

        ageTextJField.setEditable(false);
        ageTextJField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 18)); // NOI18N
        jLabel8.setText("Personal Information");

        jLabel1.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Name: ");

        nameTextJField.setEditable(false);
        nameTextJField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nationality:");

        nationalityTextJField.setEditable(false);
        nationalityTextJField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        nationalityTextJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nationalityTextJFieldActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 18)); // NOI18N
        jLabel9.setText("Contact Information");

        emailIDTextJField.setEditable(false);
        emailIDTextJField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        emailIDTextJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailIDTextJFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel5.setText("Email Id:");

        jLabel6.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel6.setText("Contact Number:");

        contactNumberTextJField.setEditable(false);
        contactNumberTextJField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        contactNumberTextJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactNumberTextJFieldActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel13.setText("Address:");

        addressjTextArea1.setEditable(false);
        addressjTextArea1.setColumns(20);
        addressjTextArea1.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        addressjTextArea1.setRows(5);
        jScrollPane5.setViewportView(addressjTextArea1);

        jLabel14.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel14.setText("City:");

        cityTextJField.setEditable(false);
        cityTextJField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        cityTextJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityTextJFieldActionPerformed(evt);
            }
        });

        pincodeTextJField.setEditable(false);
        pincodeTextJField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        pincodeTextJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pincodeTextJFieldActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jLabel15.setText("Pincode:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(45, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel13)
                                                .addComponent(jLabel4))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(contactNumberTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(emailIDTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(nameTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(pincodeTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cityTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(3, 3, 3)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(nationalityTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(ageTextJField)
                                                            .addComponent(sexTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21))
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(pptjCheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(wordjCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(exceljCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(emailjCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(webjCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(languageJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cancelRequestJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelRequestJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nameTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(sexTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ageTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nationalityTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(emailIDTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(contactNumberTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel15))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cityTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pincodeTextJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(languageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(wordjCheckBox)
                            .addComponent(emailjCheckBox)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exceljCheckBox)
                            .addComponent(webjCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pptjCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(197, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        EducationDepartmentWorkAreaJPanel dwjp = (EducationDepartmentWorkAreaJPanel) component;
        dwjp.populateRequestTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void cancelRequestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelRequestJButtonActionPerformed
        int selectedRow = volunteerListJTable.getSelectedRow();
        if(selectedRow>=0){
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to decline this volunteer request??","Warning",selectionButton);
            if(selectionResult == JOptionPane.YES_OPTION){
                UserAccount volunteer = (UserAccount) volunteerListJTable.getValueAt(selectedRow, 0);

                    volunteer.getWorkQueue().getWorkRequestList().remove(request);
                    request.getUsersList().remove(volunteer);
                    int currentVac = request.getCurrentVacancy();
                    request.setCurrentVacancy(currentVac + 1);
                    if(request.getCurrentVacancy() == 0){
                        request.setStatus("Completed");
                    } else if(request.getCurrentVacancy() == request.getNumberOfVolunteers()){
                        request.setStatus("Sent");
                    } else {
                       request.setStatus("Pending");
                    }
                    
                    populateVolunteerTable();
                    populateBlankDetails();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
        }
    }//GEN-LAST:event_cancelRequestJButtonActionPerformed

    private void volunteerListJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volunteerListJTableMouseClicked
        int selectedrow = volunteerListJTable.getSelectedRow();
        if (selectedrow >= 0){
            UserAccount volunteer = (UserAccount)volunteerListJTable.getValueAt(selectedrow, 0);
            populateVolunteerDetails(volunteer);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row first","Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_volunteerListJTableMouseClicked

    private void wordjCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordjCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wordjCheckBoxActionPerformed

    private void languageJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_languageJTextFieldActionPerformed

    private void nationalityTextJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nationalityTextJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nationalityTextJFieldActionPerformed

    private void emailIDTextJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailIDTextJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailIDTextJFieldActionPerformed

    private void contactNumberTextJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactNumberTextJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactNumberTextJFieldActionPerformed

    private void cityTextJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityTextJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityTextJFieldActionPerformed

    private void pincodeTextJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pincodeTextJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pincodeTextJFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressjTextArea1;
    private javax.swing.JTextField ageTextJField;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton cancelRequestJButton;
    private javax.swing.JTextField cityTextJField;
    private javax.swing.JTextField contactNumberTextJField;
    private javax.swing.JTextArea educationjTextArea;
    private javax.swing.JTextField emailIDTextJField;
    private javax.swing.JCheckBox emailjCheckBox;
    private javax.swing.JCheckBox exceljCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField languageJTextField;
    private javax.swing.JTextArea languagejTextArea;
    private javax.swing.JTextField nameTextJField;
    private javax.swing.JTextField nationalityTextJField;
    private javax.swing.JTextField pincodeTextJField;
    private javax.swing.JCheckBox pptjCheckBox;
    private javax.swing.JTextField sexTextJField;
    private javax.swing.JTextArea skillsjTextArea;
    private javax.swing.JTable volunteerListJTable;
    private javax.swing.JCheckBox webjCheckBox;
    private javax.swing.JCheckBox wordjCheckBox;
    // End of variables declaration//GEN-END:variables
}
