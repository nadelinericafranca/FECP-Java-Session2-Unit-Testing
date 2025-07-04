package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(12345, "Test Holder", 0.0);
    }

    @Test
    void testDepositAValidAmount() {
        bankAccount.deposit(100);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testDepositAnInvalidAmountZero() {
        double initialBalance = bankAccount.getBalance();

        bankAccount.deposit(0);
        assertEquals(initialBalance, bankAccount.getBalance());
    }

    @Test
    void testDepositAnInvalidAmountNegative() {
        double initialBalance = bankAccount.getBalance();

        bankAccount.deposit(-50);
        assertEquals(initialBalance, bankAccount.getBalance());
    }

    @Test
    void testWithdrawAValidAmount() {
        bankAccount.deposit(200); // deposit first to properly test withdrawal
        bankAccount.withdraw(50);
        assertEquals(150, bankAccount.getBalance());
    }

    @Test
    void testWithdrawAnInvalidAmountZero() {
        bankAccount.deposit(100); // Give it some balance
        double initialBalance = bankAccount.getBalance();

        bankAccount.withdraw(0);
        assertEquals(initialBalance, bankAccount.getBalance());
    }

    @Test
    void testWithdrawAnInvalidAmountNegative() {
        bankAccount.deposit(100); // Give it some balance
        double initialBalance = bankAccount.getBalance();

        bankAccount.withdraw(-50);
        assertEquals(initialBalance, bankAccount.getBalance());
    }

    @Test
    void testWithdrawAnAmountExceedingBalance() {
        bankAccount.deposit(50); // Set an initial balance
        bankAccount.withdraw(100); // Try to withdraw more than available

        assertEquals(50, bankAccount.getBalance());
    }

    @Test
    void testGetAccountNumber() {
        assertEquals(12345, bankAccount.getAccountNumber());
    }

    @Test
    void testGetHolderName() {
        assertEquals("Test Holder", bankAccount.getHolderName());
    }

    @Test
    void testGetBalance() {
        assertEquals(0.0, bankAccount.getBalance());
        bankAccount.deposit(75.50);
        assertEquals(75.50, bankAccount.getBalance());
    }

    @Test
    void testSetBalance() {
        bankAccount.setBalance(500.0);
        assertEquals(500.0, bankAccount.getBalance());
    }

    @Test
    void testCreateAccountWithDeposit() {
        BankAccount newAccount = new BankAccount(98765, "John Doe", 1000.0);
        assertEquals(98765, newAccount.getAccountNumber());

        assertEquals("John Doe", newAccount.getHolderName());
        assertEquals(1000.0, newAccount.getBalance());
    }

    @Test
    void testCreateAccountWithoutDeposit() {
        BankAccount newAccount = new BankAccount(54321, "Jane Doe", 0.0);
        assertEquals(54321, newAccount.getAccountNumber());
        assertEquals("Jane Doe", newAccount.getHolderName());
        assertEquals(0.0, newAccount.getBalance());
    }

    @Test
    void testDefaultBankAccountConstructor() {
        BankAccount defaultAccount = new BankAccount();

        assertEquals(0, defaultAccount.getAccountNumber());
        assertNull(defaultAccount.getHolderName());
        assertEquals(0.0, defaultAccount.getBalance());
    }
}