/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jslowik
 */
public class Receipt {

    private Customer customer;
    private LineItem lineItems[] = new LineItem[0];
    private LineItem tempLineItems[] = new LineItem[lineItems.length + 1];

    public Receipt() {
    }

    public Receipt(Customer customer) {
    }

    public String getCustomer(String customerId) {
        FakeDatabase fakeDatabase = new FakeDatabase();
        customer = fakeDatabase.findCustomer(customerId);
        return customerId;

    }

    public final void addLineItem(int qty, Product prodId) {
        LineItem item = new LineItem(qty, prodId);
        
    }

    private final void addToArray(LineItem item) {
        tempLineItems[1] = item;
        lineItems = tempLineItems;
        tempLineItems = null;
        LineItem tempLineItems[] = new LineItem[lineItems.length + 1];

    }

    public double calculateSubtotal() {
        double total = 0.00;  
       
        return total;
    }

    public double calculateDiscount() {
        double dTotal = 0.00;  
        
        return dTotal;
    }

    public double calculateGrandTotal() {
        double grandTotal = 0.00;  // loop through array to add cumulatively for these
        
        return grandTotal;
    }

    public final void generateReceipt() {
        generateReceiptHeader();
        System.out.println(customer.toString());
        System.out.println("Id      " + "   Product Name               "
                + "   Unit Cost   " + "Quantity   " + "Extended Cost   "
                + "Amount Saved \n"
                + "********   ***************************   *********   ********   "
                + "*************   ************");
        
        for (int i = 0; i <= lineItems.length; i++) {
            System.out.println(LineItem.getLineItem());
        }
        
        
        generateReceiptFooter();
    }

    private final void generateReceiptHeader() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-YY HH:mm a");
        String dateTime = dateFormat.format(new Date());
        System.out.println("  \t\t\t\t " + dateTime);
        System.out.println();
    }

    private final void generateReceiptFooter() {
        System.out.println();
        System.out.printf(" \t\t\t\t\t\tSUBTOTAL  \t$%,.2f%n", calculateSubtotal());
        System.out.printf("\t\t\t\t\t\tTOTAL SAVED  \t$% ,.2f%n", calculateDiscount());
        System.out.printf(" \t\t\t\t\t\tTOTAL     \t$%,.2f%n", calculateGrandTotal());
        System.out.println();
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        
        receipt.getCustomer("100");
        receipt.generateReceipt();
        FakeDatabase data = new FakeDatabase();
        Product product = data.findProduct("A101");
        //LineItem line1 = new LineItem(2, data.findProduct("A101"));
        
        
         receipt.addLineItem(2, product);
         receipt.addToArray(item);
        
    }

}
