/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.VolunteerRole;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author vidhi
 */
public class VolunteerOrganization extends Organization {
    
    private WorkQueue donations;
    public VolunteerOrganization() {
         super(Organization.Type.Volunteer.getValue());
         donations = new WorkQueue();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new VolunteerRole());
        return roles;
    }
    
}
