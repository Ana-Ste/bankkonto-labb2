package se.ithogskolan.ana.bankkontolabb2.atm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.ithogskolan.ana.bankkontolabb2.atm.exceptions.InsufficientFundsException;
import se.ithogskolan.ana.bankkontolabb2.atm.exceptions.InvalidAmountException;
import se.ithogskolan.ana.bankkontolabb2.atm.exceptions.MaxWithdrawalExceededException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ATMServiceTest {

    @Mock
    private AccountComponent account;

    @InjectMocks
    private ATMService atmService;

    @Test
    void depositThrowsIfAmountZero() {
        assertThrows(InvalidAmountException.class,
                () -> atmService.deposit(0));

        verify(account, never()).deposit(anyInt());
    }

    @Test
    void depositOkCallsAccount() {
        atmService.deposit(100);

        verify(account).deposit(100);
        verifyNoMoreInteractions(account);
    }

    @Test
    void withdrawThrowsIfOverMax() {
        assertThrows(MaxWithdrawalExceededException.class,
                () -> atmService.withdraw(2000));

        verify(account, never()).withdraw(anyInt());
        verify(account, never()).getBalance();
        verifyNoMoreInteractions(account);
    }

    @Test
    void withdrawThrowsIfNotEnoughMoney() {
        when(account.getBalance()).thenReturn(100);

        assertThrows(InsufficientFundsException.class,
                () -> atmService.withdraw(150));

        verify(account).getBalance();
        verify(account, never()).withdraw(anyInt());
        verifyNoMoreInteractions(account);
    }

    @Test
    void withdrawOkCallsAccount() {
        when(account.getBalance()).thenReturn(500);

        atmService.withdraw(200);

        verify(account).getBalance();
        verify(account).withdraw(200);
        verifyNoMoreInteractions(account);
    }

    @Test
    void getBalanceReturnsBalanceFromAccount() {
        when(account.getBalance()).thenReturn(777);

        int balance = atmService.getBalance();

        assertEquals(777, balance);
        verify(account).getBalance();
        verifyNoMoreInteractions(account);
    }
}
