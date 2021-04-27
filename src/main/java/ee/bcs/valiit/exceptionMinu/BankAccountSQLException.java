package ee.bcs.valiit.exceptionMinu;

public class BankAccountSQLException extends RuntimeException {

    public BankAccountSQLException(String message) {
        super(message);
    }
}
