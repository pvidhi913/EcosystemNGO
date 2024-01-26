/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.HealthOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import UserInterface.HealthRole.HealthDepartmentDoctorWorkAreaJPanel;
import UserInterface.HealthRole.HealthDepartmentWorkAreaJPanel;

/**
 *
 * @author vaibhaveegamit
 */
public class HealthRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new HealthDepartmentWorkAreaJPanel(userProcessContainer, account, (HealthOrganization) organization, enterprise, network);
    }
    
     @Override
    public String toString() {
        return RoleType.Health.getValue();
    }
    
}
