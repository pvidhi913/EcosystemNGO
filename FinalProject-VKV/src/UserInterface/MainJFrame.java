/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UserInterface;

import Business.ConfigureASystem;
import Business.DB4O.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author vaibhaveegamit
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    
    private EcoSystem system;
    JPanel LogoutJPanel;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();

    public MainJFrame() {
        initComponents();
        this.setSize(1680, 1050);
        Color color = new Color(180,195,195);
        LogoutJPanel blankJP = new LogoutJPanel();
        blankJP.setBackground(color);
        container.add("blank", blankJP);
        CardLayout cardLayout = (CardLayout) container.getLayout();
        cardLayout.next(container);
        system = ConfigureASystem.configure();
        system = dB4OUtil.retrieveSystem();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        container = new javax.swing.JPanel();
        container1 = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        loginJButton = new javax.swing.JButton();
        userNameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JPasswordField();
        userNameJLabel = new javax.swing.JLabel();
        passwordJLabel = new javax.swing.JLabel();
        loginJLabel = new javax.swing.JLabel();
        logoutJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        container.setLayout(new java.awt.CardLayout());

        container1.setBackground(new java.awt.Color(180, 195, 195));
        container1.setLayout(new java.awt.CardLayout());
        container.add(container1, "card2");

        jSplitPane1.setRightComponent(container);

        login.setBackground(new java.awt.Color(0, 30, 60));
        login.setToolTipText("");

        loginJButton.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        loginJButton.setText("Login");
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });

        userNameTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        passwordTextField.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N

        userNameJLabel.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        userNameJLabel.setForeground(new java.awt.Color(255, 255, 255));
        userNameJLabel.setText("UserName");

        passwordJLabel.setFont(new java.awt.Font(".SF NS Mono", 0, 14)); // NOI18N
        passwordJLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordJLabel.setText("Password");

        logoutJButton.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        logoutJButton.setText("Logout");
        logoutJButton.setEnabled(false);
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginJLabel)
                    .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(passwordTextField)
                        .addComponent(userNameJLabel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(passwordJLabel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(userNameTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(loginJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(userNameJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(passwordJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginJButton)
                .addGap(18, 18, 18)
                .addComponent(logoutJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginJLabel)
                .addContainerGap(318, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(login);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed
        
        // Get username
        String userName = userNameTextField.getText();
        // Get password
        char[] passwordCharArray = passwordTextField.getPassword();
               
        String password = String.valueOf(passwordCharArray);

        //Step1: Check in the SystemAdmin user account directory if you have the user
        UserAccount userAccount = system.getUserAccountDirectory().authenticateUser(userName, password);

        Enterprise inEnterprise = null;
        Organization inOrganization = null;
        Network inNetwork = null;

        if(userAccount==null){
            //Step 2: Go inside each network
            for(Network network : system.getNetworkList()){
                //Step 2.a: check against each enterprise under network
                for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
                    userAccount = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                    if(userAccount==null){
                        //Step 3:check against each organization for each enterprise
                        for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                            userAccount = organization.getUserAccountDirectory().authenticateUser(userName, password);
                            if(userAccount!=null){
                                inEnterprise=enterprise;
                                inOrganization=organization;
                                inNetwork=network;
                                break;
                            }
                        }
                    }
                    else{
                        inEnterprise=enterprise;
                        break;
                    }
                    if(inOrganization!=null){
                        break;
                    }
                }
                if(inEnterprise!=null){
                    break;
                }
            }
        }

        if(userAccount==null){
            JOptionPane.showMessageDialog(null, "Invalid credentials");
            return;
        }
        else{
            CardLayout layout = (CardLayout)container.getLayout();
            container.add("workArea",userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, inNetwork, system));
            layout.next(container);
        }

        loginJButton.setEnabled(false);
        logoutJButton.setEnabled(true);
        userNameTextField.setEnabled(false);
        passwordTextField.setEnabled(false);
        
    }//GEN-LAST:event_loginJButtonActionPerformed

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        
        loginJButton.setEnabled(true);
        logoutJButton.setEnabled(false);
        userNameTextField.setEnabled(true);
        passwordTextField.setEnabled(true);

        userNameTextField.setText("");
        passwordTextField.setText("");

        container.removeAll();
        Color color = new Color(180,195,195);
        LogoutJPanel blankJP = new LogoutJPanel();
        blankJP.setBackground(color);
        container.add("blank", blankJP);
        CardLayout cardLayout = (CardLayout) container.getLayout();
        cardLayout.next(container);
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_logoutJButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JPanel container1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel login;
    private javax.swing.JButton loginJButton;
    private javax.swing.JLabel loginJLabel;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JLabel passwordJLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JLabel userNameJLabel;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables
}