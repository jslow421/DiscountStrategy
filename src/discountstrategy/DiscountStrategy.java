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
public interface DiscountStrategy {

    double getAmountSaved(double unitPrice, int qty);

    double getDiscountRate();

    double getDiscountedProductTotal(double unitPrice, int qty);

    void setDiscountRate(double discountRate);
    
    //no discount class would work the same but would return zero
    
}
