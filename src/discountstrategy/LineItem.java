/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

import java.text.DecimalFormat;

/**
 *
 * @author jslowik
 */
public class LineItem {

    //double lineTotal;

    private int qty;
    private Product product;

    public LineItem(int qty, String productId) {
        this.qty = qty;
        FakeDatabase db = new FakeDatabase();
        product = db.findProduct(productId);
    }

    public LineItem(int qty, Product product) {
        this.qty = qty;
        this.product = product;
    }
    
    public final String getLineItem() {
        String pId = product.getProdID();
        String pName = product.getName();
        double uCost = product.getUnitPrice();
        double extendedCost = (product.getUnitPrice() * qty);
        double pDiscount = product.getDiscountedProductTotal(qty);
        
        // format decimal
        DecimalFormat df = new DecimalFormat("$#,##0.00");  
        return pId + "   " + pName + "   " + df.format(uCost) + " \t " + qty
                + "\t" + df.format(extendedCost) + "\t\t" + df.format(pDiscount);
    }

    
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        if (qty > 0) {
            this.qty = qty;
        } else {
            System.out.println("Quantity cannot be zero!");
        }

    }
    public double calculateSubtotal() {
        return product.getUnitPrice()* qty;
    }
    public double calculateDiscount() {
        return product.getDiscountedProductTotal(qty);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getName(Product p) {
        return p.getName();
    }

    public double getDiscountedPrice(Product p) {//this is an example of an object talking to another
        return p.getDiscountedProductTotal(qty);
    }

    public double getLineSubtotal(Product p) {
        return p.getUnitPrice() * qty;
    }

    //testing method -- not part of program
    public static void main(String[] args) {
        /*
        Product product1 = new Product("A100", "Hat", 20.00, new PercentOffDiscount(.10));
        Product product2 = new Product("A100", "Ball bag", 20.00, new PercentOffDiscount(.10));

        LineItem line = new LineItem(2,"A100");

        //line.setProduct(product1);
        System.out.println("Product Name: " + line.getName(product1));
        System.out.println("Quantity: " + line.getQty());
        System.out.println("Subtotal: $" + line.getLineSubtotal(product1));
        System.out.println("Discounted Total: $" + line.getDiscountedPrice(product1));

        //line.product.getName();
        //System.out.println(line.product.getName());
        //line.setProduct(product2);
        //System.out.println(line.product.getName())
        Product stuff[] = new Product[2];

        stuff[0] = product1;
        stuff[1] = product2;

        System.out.println(stuff[1].getName());
        */
        LineItem lineItem = new LineItem(3,"A101");
        LineItem lineItem2 = new LineItem(6,"B205");
        //System.out.println(lineItem.getQty());
        //System.out.println(lineItem.calculateSubtotal());
        //System.out.println(lineItem.calculateDiscount());
        System.out.println(lineItem.getLineItem());
        System.out.println(lineItem2.getLineItem());
        

    }
}
