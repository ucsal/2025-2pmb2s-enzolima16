package br.com.mariojp.solid.srp;

public class TaxCalculator {
    public static double calculator (double subtotal){
        String tax = System.getProperty("tax.rate");
        if(tax == null){
            return subtotal * 0.03;
        } else {
            return subtotal * Double.parseDouble(tax);
        }
    }
}
