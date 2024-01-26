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
public class LogisticEnterprise extends Enterprise {
    
    public enum Type{
       Transport("Transport Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public LogisticEnterprise(String name){
        super(name,Enterprise.EnterpriseType.Logistic);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
