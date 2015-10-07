/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author John
 */
public class Customer {
    private String customerId;
    private String customerName;

    public Customer(String customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }
    
    public final void setCustomerId(String customerId) {
        if (customerId != null) {
            this.customerId = customerId;
        } else {
            System.out.println("Customer ID cannot be null");
        }
    }

    public String getCustomerName() {
        return customerName;
    }
    
    public final void setCustomerName(String customerName) {
        if (customerName != null) {
            this.customerName = customerName;
        } else {
            System.out.println("Customer name cannot be null");
        }
    }
    
    @Override
    public String toString() {
        String customer = "  \t\t\tCustomer ID: " + customerId 
                + "\tCustomer Name: " + customerName;
        return customer;
    }
}
