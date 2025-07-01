package Logger;

public class ErrorLogger {
    private String errorLogFilePath = "../../log/error_log.txt";

    public ErrorLogger() {
        // Initialize the error logger, e.g., set up file writer or other resources
    }

    public void logError(String message, Exception exception) {
        // Log the error message to the specified file
        try (java.io.FileWriter writer = new java.io.FileWriter(errorLogFilePath, true)) {
            writer.write(message + ": " + exception.getMessage() + "\n");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
