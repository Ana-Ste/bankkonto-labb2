package se.ithogskolan.ana.bankkontolabb2.atm;

import org.springframework.stereotype.Service;
import se.ithogskolan.ana.bankkontolabb2.atm.exceptions.InsufficientFundsException;
import se.ithogskolan.ana.bankkontolabb2.atm.exceptions.InvalidAmountException;
import se.ithogskolan.ana.bankkontolabb2.atm.exceptions.MaxWithdrawalExceededException;

@Service
public class ATMService {

    private final AccountComponent account;

    private static final int MAX_WITHDRAWAL = 1000;

    public ATMService(AccountComponent account) {
        this.account = account;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be > 0");
        }
        account.deposit(amount);
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be > 0");
        }
        if (amount > MAX_WITHDRAWAL) {
            throw new MaxWithdrawalExceededException("Max is " + MAX_WITHDRAWAL);
        }

        if (amount > account.getBalance()) {
            throw new InsufficientFundsException("Not enough money");
        }

        account.withdraw(amount);
    }

    public int getBalance() {
        return account.getBalance();
    }
}
