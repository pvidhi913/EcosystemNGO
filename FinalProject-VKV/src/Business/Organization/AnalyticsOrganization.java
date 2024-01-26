/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AnalystRole;
import Business.Role.PharmacistRole;
import Business.Role.Role;
import Business.Role.VolunteerRole;
import java.util.ArrayList;

/**
 *
 * @author vidhi
 */
public class AnalyticsOrganization extends Organization{
    
    public AnalyticsOrganization() {
        super(Organization.Type.Analytics.getValue());
        
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new AnalystRole());
        return roles;
    }
    
}
