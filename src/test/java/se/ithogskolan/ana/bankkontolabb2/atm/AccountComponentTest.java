package se.ithogskolan.ana.bankkontolabb2.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountComponentTest {

    private AccountComponent account;

    @BeforeEach
    void setUp() {
        account = new AccountComponent();
    }

    @Test
    void startBalanceIsZero() {
        assertEquals(0, account.getBalance());
    }

    @Test
    void depositIncreasesBalance() {
        account.deposit(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    void withdrawDecreasesBalance() {
        account.deposit(200);
        account.withdraw(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void multipleOperationsWork() {
        account.deposit(100);
        account.deposit(30);
        account.withdraw(20);
        assertEquals(110, account.getBalance());
    }
}
