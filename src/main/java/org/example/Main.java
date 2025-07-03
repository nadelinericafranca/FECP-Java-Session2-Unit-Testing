package org.example;

import java.util.*;

public class Main { // BankSystem main class
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        int choice;
        String returnToMenu;

        int accountNumber;
        String holderName;

        do {
            System.out.println("=== Bank Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");

            System.out.print("Enter choice (1-6): ");
            choice = input.nextInt();

            switch (choice) {
                case 1: // Create Account
                    System.out.print("Enter Account Number: ");
                    accountNumber = input.nextInt();

                    System.out.print("Enter Holder Name: ");
                    holderName = input.next();

                    String makeInitialDeposit;
                    double initialDeposit = 0;

                    do {
                        System.out.print("Initial deposit? (yes/no): ");
                        makeInitialDeposit = input.next();

                        if (!makeInitialDeposit.equalsIgnoreCase("yes") && !makeInitialDeposit.equalsIgnoreCase("no")) {
                            System.out.println("Please answer YES or NO only.");
                        } else if (makeInitialDeposit.equalsIgnoreCase("yes")) {
                            do {
                                System.out.print("Enter initial deposit amount: ");
                                initialDeposit = input.nextDouble();

                                if (initialDeposit <= 0) {
                                    System.out.println("The deposit amount must be greater than 0");
                                }
                            } while (initialDeposit <= 0);
                        }
                    } while (!makeInitialDeposit.equalsIgnoreCase("yes") && !makeInitialDeposit.equalsIgnoreCase("no"));

                    BankAccount newAccount = new BankAccount(accountNumber, holderName, initialDeposit);
                    accounts.add(newAccount);
                    System.out.println("Account created successfully.");
                    break;

                case 2: // View All Accounts
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available.");
                    } else {
                        for (BankAccount acc : accounts) {
                            acc.displayInformation();
                        }
                    }
                    break;

                case 3: // Check Balance
                    System.out.print("Enter Account Number: ");
                    accountNumber = input.nextInt();

                    boolean found = false;
                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber() == accountNumber) {
                            acc.displayInformation();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4: // Deposit
                    System.out.print("Enter Account Number: ");
                    accountNumber = input.nextInt();

                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = input.nextDouble();

                    found = false;
                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber() == accountNumber) {
                            if (depositAmount <= 0) {
                                System.out.println("The deposit amount must be greater than 0");
                            } else {
                                acc.deposit(depositAmount);
                                System.out.printf("Deposited %.2f successfully!\n", depositAmount);
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5: // Withdraw
                    System.out.print("Enter Account Number: ");
                    accountNumber = input.nextInt();

                    System.out.print("Enter amount to withdraw: ");
                    double withdrawalAmount = input.nextDouble();

                    found = false;
                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber() == accountNumber) {
                            if (withdrawalAmount <= 0) {
                                System.out.println("The withdrawal amount must be greater than 0");
                            } else if (acc.getBalance() < withdrawalAmount) {
                                System.out.println("Withdrawal amount exceeds balance.");
                            } else {
                                acc.withdraw(withdrawalAmount);
                                System.out.printf("Withdrew %.2f successfully!\n", withdrawalAmount);
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6: // Exit
                    System.out.println("---Thank you!---");
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please choose between 1-6.");
            }

            System.out.println();
            System.out.print("Would you like to return to the menu? (yes/no): ");
            returnToMenu = input.next();
            System.out.println();

        } while (returnToMenu.equalsIgnoreCase("yes"));
    }
}