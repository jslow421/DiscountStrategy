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
public class QuantityDiscount implements DiscountStrategy {

    //right click class name > refactor > extract interface > provide name > click all boxes
    private double discountRate;
    private int minQty;

    public QuantityDiscount(double discountRate, int minQty) {
        this.discountRate = discountRate;
        this.minQty = minQty;
    }

    @Override
    public double getDiscountedProductTotal(double unitPrice, int qty) {
        if (qty >= minQty) {
            return (unitPrice * qty) - getAmountSaved(unitPrice, qty);
        } else {
            return unitPrice * qty;
        }
    }

    @Override
    public double getAmountSaved(double unitPrice, int qty) {
        if (qty >= minQty) {
            return (unitPrice * qty) * discountRate;
        } else {
            return 0;
        }
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getMinQty() {
        return minQty;
    }

    public void setMinQty(int minQty) {
        this.minQty = minQty;
    }


}
