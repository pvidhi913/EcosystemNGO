/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author VaibhaveeGamit
 */
public class NGOEnterprise extends Enterprise {
    
    public enum Type{
        Admin("Admin Organization"), Health("Health Organization"), Volunteer("Volunteer Organization"), Education("Education Organization"), Inventory("Inventory Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    
    public NGOEnterprise(String name){
        super(name,Enterprise.EnterpriseType.NGO);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
