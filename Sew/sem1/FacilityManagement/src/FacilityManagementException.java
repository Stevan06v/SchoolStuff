
public class FacilityManagementException extends RuntimeException{
    public static final short ZIP_CODE_NOT_FOUND_MESSAGE = 0;

    public FacilityManagementException(String message) {
        super(message);
    }

    public FacilityManagementException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacilityManagementException(Throwable cause) {
        super(cause);
    }

    public FacilityManagementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
