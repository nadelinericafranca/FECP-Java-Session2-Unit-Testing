package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
    private int accountNumber;
    private String holderName;
    private double balance;

    // Constructor declaration of class
    public BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public BankAccount() {
    }

    public void deposit(double depositAmount) {
        this.balance += depositAmount;
    }

    public void withdraw(double withdrawAmount) {
        this.balance -= withdrawAmount;
    }

    public void displayInformation() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }

    // getter method
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // setter methods
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
