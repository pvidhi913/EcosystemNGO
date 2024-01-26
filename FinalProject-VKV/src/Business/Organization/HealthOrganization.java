/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.HealthRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author vidhi
 */
public class HealthOrganization extends Organization {
    
    public HealthOrganization() {
        super(Organization.Type.Health.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new HealthRole());
        return roles;
    }
    
}
