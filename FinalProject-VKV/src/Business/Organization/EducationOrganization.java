/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.EducationRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author vidhi
 */
public class EducationOrganization extends Organization {
    
    public EducationOrganization() {
        super(Organization.Type.Education.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new EducationRole());
        return roles;
    }
    
}
