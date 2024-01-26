/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author vidhi
 */
public abstract class Organization {
    
    private String name;
    private int organizationID;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private WorkQueue workQueue;
    Random random = new Random();
    
    public enum Type {
        
        Admin("Admin Organization"), 
        Analytics("Analytics Organization"),
        Doctor("Doctor Organization"), 
        Education("Education Organization"),
        Health("Health Organization"), 
        Inventory("Inventory Organization"), 
        Lab("Lab Organization"),
        Pharmacy("Pharmacy Organization"), 
        Transport("Transport Organization"), 
        Volunteer("Volunteer Organization");
      
        private String value;
        
        private Type(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name; 
        this.workQueue = new WorkQueue();
        this.organizationID = random.nextInt(10000);
        this.employeeDirectory = new EmployeeDirectory();
        this.userAccountDirectory = new UserAccountDirectory();
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
