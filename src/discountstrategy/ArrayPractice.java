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
public class ArrayPractice {
    public static void main(String[] args) {
        String[] names = new String[0];//create empty array, and resize later
        String[] temp = new String[names.length + 1]; //create second array that is one larger than first
        
        for (int i = 0; i < names.length; i++) {
            temp[i] = names[i];
        }
        temp[temp.length-1] = "Hello"; //adds "hello" to last place in temp
        names = temp; //sets name equal to the expanded array
        temp = null; //destroys temp array
    }
}
