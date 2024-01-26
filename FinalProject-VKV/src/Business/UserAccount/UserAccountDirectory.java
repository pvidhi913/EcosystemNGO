/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Employee.Volunteer;
import Business.Role.Role;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author kashyap
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;
    
    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public boolean checkIfUsernameIsUnique(String userName){
        for (UserAccount ua : userAccountList){
            if (ua.getUserName().equals(userName))
                return false;
        }
        return true;
    }
    
    public UserAccount authenticateUser(String userName, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUserName().equals(userName) && BCrypt.checkpw(password,ua.getPassword())){
                return ua;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String userName, String password, Employee employee, Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(userName);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public UserAccount createUserAccount(String userName, String password, Volunteer employee, Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(userName);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    } 
}
