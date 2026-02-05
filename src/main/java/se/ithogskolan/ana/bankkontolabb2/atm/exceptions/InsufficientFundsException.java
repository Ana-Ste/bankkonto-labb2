package se.ithogskolan.ana.bankkontolabb2.atm.exceptions;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
