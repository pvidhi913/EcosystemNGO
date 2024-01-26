/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author kashi
 */
public class VolunteerInventoryWorkRequest extends WorkRequest{
    Random random = new Random();
    private ArrayList<String> category=null;
    private ArrayList<Integer> quantity=null;
    private ArrayList<String> description=null;
    private Date pickupDate=null;
    private Date expectedDelivery=null;
    private int orderID=0;
    private String senderAddress=null;
    private String recieverAddress=null;
    private String senderNumber=null;
    private String recieverNumber=null;
    private String deliveryNumber=null;
    private UserAccount delivery=null;

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

    public String getSenderAddress() {
        return senderAddress;
    }

    public String getSenderNumber() {
        return senderNumber;
    }

    public Date getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(Date expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
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
    
    

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getRecieverAddress() {
        return recieverAddress;
    }

    public void setRecieverAddress(String recieverAddress) {
        this.recieverAddress = recieverAddress;
    }
    
    
    public VolunteerInventoryWorkRequest() {
        category= new ArrayList();
        quantity = new ArrayList();
        description = new ArrayList();
        orderID = random.nextInt(10000);
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    
    public ArrayList<String> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<String> category) {
        this.category = category;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<Integer> quantity) {
        this.quantity = quantity;
    }

    

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }
    
    

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }
    
    public String toString() {
        String id = String.valueOf(this.orderID);//To change body of generated methods, choose Tools | Templates.
        return id;
    }
}
