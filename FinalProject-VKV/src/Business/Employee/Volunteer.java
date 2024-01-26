/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author  kashyap
 */
public class Volunteer extends Employee{
    
    private String address = null;
    private String city = null;
    private String pinCode = null;
    private String englishProficency = null;
    private ArrayList<String> languageList = new ArrayList();
    private ArrayList<String> skillList = new ArrayList();
    private String additionalSkills = null;
    private ArrayList<String> expertiseList = new ArrayList();
    private String education = null;
    private String schoolName = null;
    private String degree = null;
    private Map<String, String> educationMap = new HashMap<String, String>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getEnglishProficency() {
        return englishProficency;
    }

    public void setEnglishProficency(String englishProficency) {
        this.englishProficency = englishProficency;
    }

    public ArrayList<String> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(ArrayList<String> languageList) {
        this.languageList = languageList;
    }

    public ArrayList<String> getSkillList() {
        return skillList;
    }

    public void setSkillList(ArrayList<String> skillList) {
        this.skillList = skillList;
    }

    public String getAdditionalSkills() {
        return additionalSkills;
    }

    public void setAdditionalSkills(String additionalSkills) {
        this.additionalSkills = additionalSkills;
    }

    public ArrayList<String> getExpertiseList() {
        return expertiseList;
    }

    public void setExpertiseList(ArrayList<String> expertiseList) {
        this.expertiseList = expertiseList;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Map<String, String> getEducationMap() {
        return educationMap;
    }

    public void setEducationMap(Map<String, String> educationMap) {
        this.educationMap = educationMap;
    }
}
