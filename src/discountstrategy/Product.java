/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author jslowik
 */
public class Product {
    private String prodID;
    private String name;
    private double unitPrice;
    private DiscountStrategy discount; // composition - this is good as it is an abstraction

    public Product(String prodID, String name, double unitPrice, DiscountStrategy discount) {
        this.prodID = prodID;
        this.name = name;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    public Product() {
        //empty constructor to make use of setters
    }
    
    public double getAmountSaved(int qty){
        return discount.getAmountSaved(unitPrice, qty); //delegate work to discount object
    }
    
     public double getDiscountedProductTotal(int qty){
        return discount.getDiscountedProductTotal(unitPrice, qty);//same delegation as above
    }

    public String getProdID() {
        return prodID;
    }

    public void setProdID(String prodID) {
        this.prodID = prodID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public DiscountStrategy getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountStrategy discount) {
        this.discount = discount;
    }
    //testing
    public static void main(String[] args) {
        Product product = new Product("A100","Hat", 20.00, new PercentOffDiscount(.10));
        double amtSaved = product.getAmountSaved(2);
        System.out.println("Expected 4.00, and got " + amtSaved);
        
        Product product2 = new Product("A100","Hat", 20.00, new QuantityDiscount(.10,2));
        double amtSaved2 = product.getAmountSaved(2);
        System.out.println("Expected 4.00, and got " + amtSaved2);
    }
    
    
    
}
