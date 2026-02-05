package se.ithogskolan.ana.bankkontolabb2.atm.exceptions;

public class MaxWithdrawalExceededException extends RuntimeException {
    public MaxWithdrawalExceededException(String message) {
        super(message);
    }
}
