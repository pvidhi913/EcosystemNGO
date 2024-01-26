/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.AdminWorkArea.AdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author vaibhaveegamit
 */
public class AdminRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,Network network, EcoSystem business) {
        return new AdminWorkAreaJPanel(userProcessContainer,network, enterprise);
  
    }
    
    @Override
    public String toString() {
        return RoleType.Admin.getValue();
    }
}
