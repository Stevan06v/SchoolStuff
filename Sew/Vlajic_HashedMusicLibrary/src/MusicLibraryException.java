public class MusicLibraryException extends RuntimeException {
    public static final String PARSING_EXCEPTION_MESSAGE = "Exception occurred while parsing line!";
    public static final String IO_EXCEPTION_MESSAGE = "Exception occurred while loading tracks from file!";

    public MusicLibraryException(String message) {
        super(message);
    }

    public MusicLibraryException(String message, Throwable cause) {
        super(message, cause);
    }
}
