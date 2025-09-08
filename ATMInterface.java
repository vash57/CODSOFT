/*
* PROJECT: ATM INTERFACE
* Internship:CODSOFT
* Task: 3
* Description: 

 This project simulates an ATM machine. 
It allows users to withdraw money, deposit money, and check balance.
The ATM class connects with a BankAccount class to store account details.
Input validation ensures users cannot withdraw more than their balance.
Messages are displayed for successful or failed transactions.* 

Author: DEV KUMAR CHAUBEY
* Date : 9 Sep 2025
*/
import java.util.Scanner;

class BankAccount {
    double balance;

    BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs." + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdraw amount!");
        } else if (amount > balance) {
            System.out.println("Not enough balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: Rs." + amount);
        }
    }

    void checkBalance() {
        System.out.println("Current Balance: Rs.1" + balance);
    }
}

class ATM {
    BankAccount account;

    ATM(BankAccount acc) {
        account = acc;
    }

    void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 3:
                    System.out.print("Enter withdraw amount: ");
                    double wd = sc.nextDouble();
                    account.withdraw(wd);
                    break;
                case 4:
                    System.out.println("Thank you, exiting ATM.");
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        } while (choice != 4);
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount myAcc = new BankAccount(1000); // starting balance
        ATM atm = new ATM(myAcc);
        atm.showMenu();
    }
}

