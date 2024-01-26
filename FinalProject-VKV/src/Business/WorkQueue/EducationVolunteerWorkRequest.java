/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author vidhi
 */
public class EducationVolunteerWorkRequest extends WorkRequest {
    
    private String jobTitle;
    private Date date;
    private String time;
    private String place;
    private String area;
    private int numberOfStudents;
    private int numberOfhours;
    private int numberOfVolunteers;
    private int currentVacancy;
    private ArrayList<UserAccount> usersList;
    
    public EducationVolunteerWorkRequest(){
        usersList = new ArrayList<UserAccount>();
        
    }

    public ArrayList<UserAccount> getUsersList() {
        return usersList;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumberOfhours() {
        return numberOfhours;
    }

    public void setNumberOfhours(Integer numberOfhours) {
        this.numberOfhours = numberOfhours;
    }

    public int getNumberOfVolunteers() {
        return numberOfVolunteers;
    }

    public void setNumberOfVolunteers(int numberOfVolunteers) {
        this.numberOfVolunteers = numberOfVolunteers;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getCurrentVacancy() {
        return currentVacancy;
    }

    public void setCurrentVacancy(int currentVacancy) {
        this.currentVacancy = currentVacancy;
    }
    
    
    @Override
    public String toString() {
        String id = String.valueOf(this.jobTitle);//To change body of generated methods, choose Tools | Templates.
        return id;
    }
    
    
    
}
