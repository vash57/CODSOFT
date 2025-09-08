/*
* PROJECT: CURRENCY CONVERTER
* Internship:CODSOFT
* Task: 4
* Description: 

* Currency Converter: Converts money between currencies.
User selects base/target currency, 
enters amount, system fetches rate, 
converts, and shows result with proper validation.

* Author: DEV KUMAR CHAUBEY
* Date : 10 Sep 2025
*/
import java.util.Scanner;

public class CurrencyConverter{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("--- Currency Converter ---");
        System.out.print("Enter base currency (USD/INR/EUR): ");
        String from=sc.next();

        System.out.print("Enter target currency (USD/INR/EUR): ");
        String to=sc.next();

        System.out.print("Enter amount: ");
        double amount=sc.nextDouble();

        double rate=0;

        // some fixed rates 
        if (from.equals("USD") && to.equals("INR")) {
            rate=83;
        } else if (from.equals("INR") && to.equals("USD")) {
            rate=0.012;
        } else if (from.equals("USD") && to.equals("EUR")) {
            rate=0.92;
        } else if (from.equals("EUR") && to.equals("USD")) {
            rate=1.09;
        } else if (from.equals("INR") && to.equals("EUR")) {
            rate=0.011;
        } else if (from.equals("EUR") && to.equals("INR")) {
            rate = 90;
        } else {
            System.out.println("This conversion is not available.");
        }

        if (rate != 0) {
            double converted = amount * rate;
            System.out.println(amount + " "+ from + " = " + converted + " " + to);
        }

        sc.close();
    }
}

