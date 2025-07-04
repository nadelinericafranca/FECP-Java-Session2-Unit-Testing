package org.example;

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
        if (depositAmount <= 0) {
            System.out.println("The deposit amount must be greater than 0");
        } else {
            this.balance += depositAmount;
        }
    }

    public void withdraw(double withdrawalAmount) {
        if (withdrawalAmount <= 0) {
            System.out.println("The withdrawal amount must be greater than 0");
        } else if (this.balance < withdrawalAmount) {
            System.out.println("Withdrawal amount exceeds balance.");
        } else {
            this.balance -= withdrawalAmount;
        }
    }

    public void displayInformation() {
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Holder Name: " + this.holderName);
        System.out.println("Balance: " + this.balance);
        System.out.println("--------------------------------");
    }

    // getter method
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // setter methods
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
