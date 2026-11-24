package observer;

import ensisa.Page;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

/** Observateur qui transmet les événements à une API HTTP (POST JSON). */
public class ApiLoggerObserver implements LoggerObserver {
    private final HttpClient client = HttpClient.newHttpClient();
    private final URI endpoint;

    public ApiLoggerObserver(String endpoint) {
        this.endpoint = URI.create(endpoint);
    }

    @Override
    public void update(String action, Page page) {
        String json = "{\"date\":\"" + LocalDateTime.now()
                + "\",\"action\":\"" + escape(action)
                + "\",\"page\":\"" + escape(page.getTitle()) + "\"}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endpoint)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {
            HttpResponse<String> response = client.send(
                    request, HttpResponse.BodyHandlers.ofString());
            System.out.println("API logger : réponse HTTP " + response.statusCode());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Envoi API interrompu : " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Échec de l'envoi API : " + e.getMessage());
        }
    }

    private String escape(String value) {
        return value.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
