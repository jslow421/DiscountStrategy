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
// PercentOffDiscount is a special type of DiscountStrategy (that's how you know you have good naming)
public class PercentOffDiscount implements DiscountStrategy {
    //right click class name > refactor > extract interface > provide name > click all boxes
    private double discountRate;

    public PercentOffDiscount(double discountRate) {
        this.discountRate = discountRate;
    }
    
    @Override
    public double getDiscountedProductTotal(double unitPrice, int qty){
        return (unitPrice * qty) - getAmountSaved(unitPrice, qty);
    }
    
    
    
    @Override
    public double getAmountSaved(double unitPrice, int qty){
        return (unitPrice * qty) * discountRate;
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    
    public static void main(String[] args) {
        //this method is for testing purposes only!!!!!
        DiscountStrategy discount = new QuantityDiscount(.10,5);//QuantityDiscount and other are interchangeable now
        //discount.setDiscountRate(.10); add constructor to allow this line to be removed
        double amt = discount.getAmountSaved(10.00, 5);
        System.out.println("Discount amount: " + amt);
        double newTotal = discount.getDiscountedProductTotal(10.00, 2);
        System.out.println("Discounted product total " + newTotal);
    }
    
}
