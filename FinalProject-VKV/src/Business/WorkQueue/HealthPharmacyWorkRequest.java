/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Medicine.Medicine;
import Business.UserAccount.UserAccount;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author vidhi
 */
public class HealthPharmacyWorkRequest extends WorkRequest{
    Random random = new Random();
    private List<Medicine> medicineList = null;
    private String prescription = null;
    private String street = null;
    private String area=null;
    private String city=null;
    private String state=null;
    private String pinCode=null;
    private String address=null;
    private String ngo=null;
    private String message=null;
    
    private String senderAddress=null;
    private String recieverAddress=null;
    private String senderNumber=null;
    private String recieverNumber=null;
    private String deliveryNumber=null;
    private UserAccount delivery=null;
    private Date pickupDate=null;
    private Date expectedDelivery=null;
    
    private int id;

    public HealthPharmacyWorkRequest(){
        super();
        id = random.nextInt(10000);
    }
    
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getNgo() {
        return ngo;
    }

    public void setNgo(String ngo) {
        this.ngo = ngo;
    }

    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getRecieverAddress() {
        return recieverAddress;
    }

    public void setRecieverAddress(String recieverAddress) {
        this.recieverAddress = recieverAddress;
    }

    public String getSenderNumber() {
        return senderNumber;
    }

    public void setSenderNumber(String senderNumber) {
        this.senderNumber = senderNumber;
    }

    public String getRecieverNumber() {
        return recieverNumber;
    }

    public void setRecieverNumber(String recieverNumber) {
        this.recieverNumber = recieverNumber;
    }

    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(String deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public UserAccount getDelivery() {
        return delivery;
    }

    public void setDelivery(UserAccount delivery) {
        this.delivery = delivery;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(Date expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }
    
    @Override
    public String toString(){
        return id+"";
    }
    
    
}
