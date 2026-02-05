package se.ithogskolan.ana.bankkontolabb2.atm.exceptions;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String message) {
        super(message);
    }
}
