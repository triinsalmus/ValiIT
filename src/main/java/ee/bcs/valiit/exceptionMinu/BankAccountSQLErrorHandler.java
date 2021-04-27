package ee.bcs.valiit.exceptionMinu;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BankAccountSQLErrorHandler {

    @ExceptionHandler(BankAccountSQLException.class)
    public ResponseEntity<Object> handleError400(BankAccountSQLException exception) { //siin exception on seotud selle objektiga, mille service klassis lõime, ta seob ära
        return new ResponseEntity<Object>(new BankAccountSQLErrorResponse(exception.getMessage(), 400),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class) //ei saa ühes handleris olla mitut samast klassist pärinevat exceptionit
    public ResponseEntity<Object> handleError500(Exception exception) {
        //exception.printStackTrace(); //prindime teate - pole vaja, kui services juba prindime
        return new ResponseEntity<Object>(new BankAccountSQLErrorResponse(exception.getMessage(), 500),
                HttpStatus.INTERNAL_SERVER_ERROR); //võid kasutada koguaeg ka ühte errori teadet
    }
}
