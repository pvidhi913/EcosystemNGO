/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

/**
 *
 * @author kashyap
 */
public class Employee {
    
    private String name;
    private int employeeId;    
    private String gender;
    private String contactNumber;
    private String nationality;
    private LocalDate birthDate = LocalDate.now();
    private String emailID;
    
    Random random = new Random();

    
    public enum Type {
        
        Volunteer("Volunteer");
        
        private String value;
        
        private Type(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
    }

    public Employee() {
        this.employeeId = random.nextInt(100000);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
    
    @Override
    public String toString() {
        return name;
    }
    
}
