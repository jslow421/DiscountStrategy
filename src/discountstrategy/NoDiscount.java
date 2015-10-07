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

public class NoDiscount implements DiscountStrategy {
    
    
    
    @Override
    public double getDiscountedProductTotal(double unitPrice, int qty){
        return (unitPrice * qty) - getAmountSaved(unitPrice, qty);
    }
    
    
    
    @Override
    public double getAmountSaved(double unitPrice, int qty){
        return 0;
    }

    @Override
    public double getDiscountRate() {
        return 0;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        discountRate = 0;
    }
    
    
    public static void main(String[] args) {
        //this method is for testing purposes only!!!!!
        DiscountStrategy discount = new NoDiscount();//QuantityDiscount and other are interchangeable now
        //discount.setDiscountRate(.10); add constructor to allow this line to be removed
        double amt = discount.getAmountSaved(10.00, 5);
        System.out.println("Discount amount: " + amt);
        double newTotal = discount.getDiscountedProductTotal(10.00, 2);
        System.out.println("Discounted product total " + newTotal);
    }
    
}
