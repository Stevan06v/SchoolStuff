public class SportsEventException extends RuntimeException{    public SportsEventException(String error){        super(error);    }    public SportsEventException(String errorMessage, Throwable err) {        super(errorMessage, err);    }}