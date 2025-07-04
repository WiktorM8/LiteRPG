package Logger;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErrorLogger {
    private static final String LOG_DIR = "logs";
    private static final String LOG_FILE = "errors.log";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm:ss");

    public static void log(String message, Throwable throwable) {
        try {
            Path logDirPath = Paths.get(LOG_DIR);
            if (!Files.exists(logDirPath)) {
                Files.createDirectories(logDirPath);
            }

            Path logFilePath = logDirPath.resolve(LOG_FILE);

            String date = LocalDateTime.now().format(DATE_FORMAT);
            String logEntry = date + " | " + throwable.getClass() + " | " + throwable.getMessage() + " | " + message + System.lineSeparator();

            Files.write(logFilePath, logEntry.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        } catch (IOException e) {
            System.err.println("Nie udało się zapisać błędu do logu: " + e.getMessage());
        }
    }
}

