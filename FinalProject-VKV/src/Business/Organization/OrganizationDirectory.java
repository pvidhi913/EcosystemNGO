/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Enterprise.GovernmentEnterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.LogisticEnterprise;
import Business.Enterprise.NGOEnterprise;
import java.util.ArrayList;

/**
 *
 * @author vidhi
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createNGOOrganization(NGOEnterprise.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.Health.getValue())){
            organization = new HealthOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Education.getValue())){
            organization = new EducationOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Volunteer.getValue())){
            organization = new VolunteerOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Inventory.getValue())){
            organization = new InventoryOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
    public Organization createGovernmentOrganization(GovernmentEnterprise.Type type){
        Organization organization = null;
        if(type.getValue().equals(Organization.Type.Analytics.getValue())){
            organization = new AnalyticsOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
    public Organization createLogisticOrganization(LogisticEnterprise.Type type){
        Organization organization = null;
        if(type.getValue().equals(Organization.Type.Transport.getValue())){
            organization = new TransportOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
    public Organization createHospitalOrganization(HospitalEnterprise.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Pharmacy.getValue())){
            
            organization = new PharmacyOrganization();
            System.out.println("pharmacy "+organization.getOrganizationID());
            organizationList.add(organization);
        }
        return organization;
    }
    
}
