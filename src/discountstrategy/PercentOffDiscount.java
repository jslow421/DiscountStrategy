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
public class PercentOffDiscount {
    private double discountRate;

    public PercentOffDiscount(double discountRate) {
        this.discountRate = discountRate;
    }
    
    public double getDiscountedProductTotal(double unitPrice, int qty){
        return (unitPrice * qty) - getAmountSaved(unitPrice, qty);
    }
    
    
    
    public double getAmountSaved(double unitPrice, int qty){
        return (unitPrice * qty) * discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    
    public static void main(String[] args) {
        //this method is for testing purposes only!!!!!
        PercentOffDiscount discount = new PercentOffDiscount(.10);
        //discount.setDiscountRate(.10); add constructor to allow this line to be removed
        double amt = discount.getAmountSaved(10.00, 2);
        System.out.println("Discount amount: " + amt);
        double newTotal = discount.getDiscountedProductTotal(10.00, 2);
        System.out.println("Discounted product total " + newTotal);
    }
    
}
