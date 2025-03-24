package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;
    private BankAccount otherAccount;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000.0, 0.05); // Initial balance: 1000, Interest: 5%
        otherAccount = new BankAccount(500.0, 0.03); // Another account for transfer
    }

    @Test
    void testDepositValidAmount() {
        account.deposit(200);
        assertEquals(1200.0, account.getBalance(), 0.01);
    }

    @Test
    void testDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
    }

    @Test
    void testWithdrawValidAmount() {
        account.withdraw(500);
        assertEquals(500.0, account.getBalance(), 0.01);
    }

    @Test
    void testWithdrawExceedingAmount() {
        assertThrows(IllegalStateException.class, () -> account.withdraw(1500));
    }

    @Test
    void testWithdrawNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50));
    }

    @Test
    void testTransferValidAmount() {
        account.transfer(300, otherAccount);
        assertEquals(700.0, account.getBalance(), 0.01);
        assertEquals(800.0, otherAccount.getBalance(), 0.01);
    }

    @Test
    void testTransferExceedingAmount() {
        assertThrows(IllegalStateException.class, () -> account.transfer(2000, otherAccount));
    }

    @Test
    void testTransferNullAccount() {
        assertThrows(NullPointerException.class, () -> account.transfer(100, null));
    }

    @Test
    void testAddInterest() {
        account.addInterest();
        assertEquals(1050.0, account.getBalance(), 0.01);
    }

    @Test
    void testEdgeCaseZeroDeposit() {
        account.deposit(0);
        assertEquals(1000.0, account.getBalance(), 0.01);
    }

    @Test
    void testEdgeCaseZeroWithdraw() {
        account.withdraw(0);
        assertEquals(1000.0, account.getBalance(), 0.01);
    }

    @Test
    void testEdgeCaseZeroTransfer() {
        account.transfer(0, otherAccount);
        assertEquals(1000.0, account.getBalance(), 0.01);
        assertEquals(500.0, otherAccount.getBalance(), 0.01);
    }

    @Test
    void testNegativeInterestRate() {
        BankAccount negativeInterestAccount = new BankAccount(1000.0, -0.05);
        negativeInterestAccount.addInterest();
        assertEquals(950.0, negativeInterestAccount.getBalance(), 0.01);
    }
}
