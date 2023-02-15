import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleLogger {
    private static final String LOG_FILE_PATH_PREFIX = "logs/LOG_";
    private static final String LOG_FILE_PATH_SUFFIX = ".txt";

    private static SimpleLogger instance;

    private String fileName;

    private SimpleLogger() {
        this.fileName = LOG_FILE_PATH_PREFIX + LocalDate.now().toString() + LOG_FILE_PATH_SUFFIX;
    }

    public static SimpleLogger getInstance() {
        if(instance == null) {
            instance = new SimpleLogger();
        }
        return instance;
    }

    public void logError(String message) {
        writeToFile(LogLevel.ERROR, message);
    }

    public void logTrace(String message) {
        writeToFile(LogLevel.TRACE, message);
    }

    private void writeToFile(LogLevel logLevel, String message) {
        String line = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " " + logLevel.toString() + ": " + message + "\n";
        try {
            Files.writeString(Paths.get(this.fileName), line, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Critical error when trying to write log: " + e.getMessage());
        }
    }
}