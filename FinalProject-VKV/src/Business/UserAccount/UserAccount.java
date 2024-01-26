/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Employee.Volunteer;
import Business.Medicine.Medicine;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kashyap
 */
public class UserAccount {
    
    private String userName;
    private String password;
    private Employee employee;
    private Role role;
    private WorkQueue workQueue;
    
    private List<Medicine> medicineHistory;
    private List<Medicine> medicineList;
    
    public UserAccount() {
        workQueue = new WorkQueue();
        medicineList = new ArrayList<Medicine>();
        medicineHistory = new ArrayList<Medicine>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public List<Medicine> getMedicineHistory() {
        return medicineHistory;
    }

    public void setMedicineHistory(List<Medicine> medicineHistory) {
        this.medicineHistory = medicineHistory;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }
    
    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }
    
    public Volunteer getVolunteer() {
        return (Volunteer) employee;
    }

    @Override
    public String toString() {
        return employee.getName();
    }
    
    public boolean checkDuplicates(WorkRequest request){
        for(WorkRequest workRequest : workQueue.getWorkRequestList()){
            if(request == workRequest){
                return true;
            }  
        }
        return false;
    }
   
}
