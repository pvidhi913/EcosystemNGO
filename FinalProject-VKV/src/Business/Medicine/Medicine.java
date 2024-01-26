/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Medicine;

import java.time.LocalDate;

/**
 *
 * @author vidhi
 */
public class Medicine {
    
    private String name;
    private int quantity;
    private LocalDate orderedDate;
    
    public Medicine(String name, int quantity, LocalDate orderedDate){
        this.name = name;
        this.quantity = quantity;
        this.orderedDate = orderedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(LocalDate orderedDate) {
        this.orderedDate = orderedDate;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}
