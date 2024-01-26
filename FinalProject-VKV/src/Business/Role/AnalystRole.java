/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AnalyticsOrganization;
import Business.Organization.Organization;
import Business.Organization.PharmacyOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import UserInterface.AnalystRole.AnalystWorkAreaJPanel;
import UserInterface.PharmacistRole.PharmacistWorkAreaJPanel;
/**
 *
 * @author vaibhaveegamit
 */
public class AnalystRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new AnalystWorkAreaJPanel(userProcessContainer,account,(AnalyticsOrganization)organization,enterprise,network, business);
       
    }
    
    @Override
    public String toString() {
        return RoleType.Analyst.getValue();
    }
    
}
