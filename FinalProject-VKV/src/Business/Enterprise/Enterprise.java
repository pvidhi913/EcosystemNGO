/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;

/**
 *
 * @author vaibhaveegamit
 */
public abstract class Enterprise extends Organization {
    
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;

    public enum EnterpriseType {
        
        Government("Government"),
        Hospital("Hospital"), 
        Logistic("Logistic"),
        NGO("NGO");
        
        private String value;
        
        private EnterpriseType(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
        
        @Override
        public String toString() {
            return value;
        }
    }
    
    public Enterprise(String name, EnterpriseType type){
        super(name);
        this.enterpriseType=type;
        organizationDirectory = new OrganizationDirectory();
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }
    
    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }
    
}
