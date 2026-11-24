package observer;

import ensisa.Page;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class FileLoggerObserver implements LoggerObserver {
    private final Path logFile;

    public FileLoggerObserver(String fileName) {
        this.logFile = Path.of(fileName);
    }

    @Override
    public void update(String action, Page page) {
        String line = String.format("[%s] %s : %s%n",
                LocalDateTime.now(), action, page.getTitle());
        try {
            Files.writeString(logFile, line,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Impossible d'écrire le journal : " + e.getMessage());
        }
    }
}
