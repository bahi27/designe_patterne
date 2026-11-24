package observer;

import ensisa.Page;
import java.time.LocalDateTime;

public class ConsoleLoggerObserver implements LoggerObserver {
    @Override
    public void update(String action, Page page) {
        System.out.printf("[%s] %s : %s%n",
                LocalDateTime.now(), action, page.getTitle());
    }
}
