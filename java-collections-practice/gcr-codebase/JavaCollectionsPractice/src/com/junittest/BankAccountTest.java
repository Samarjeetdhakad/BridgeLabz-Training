package com.junittest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.junit.BankAccount;

public class BankAccountTest {
    @Test
    void testDeposit() {
        BankAccount account = new BankAccount();
        account.deposit(1000);

        assertEquals(1000, account.getBalance());
    }
    @Test
    void testWithdrawWithSufficientBalance() {
        BankAccount account = new BankAccount();
        account.deposit(1000);

        boolean result = account.withdraw(400);

        assertTrue(result);
        assertEquals(600, account.getBalance());
    }
    @Test
    void testWithdrawWithInsufficientBalance() {
        BankAccount account = new BankAccount();
        account.deposit(500);

        boolean result = account.withdraw(800);

        assertFalse(result);
        assertEquals(500, account.getBalance()); }
}