/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author vaibhavee gamit
 */
public class ConfigureASystem {
     public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        Employee employee = system.getEmployeeDirectory().createEmployee("sysadmin");
        String password = BCrypt.hashpw("sysadmin", BCrypt.gensalt());
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", password, employee, new SystemAdminRole());
        
        return system;
    }
    
}
