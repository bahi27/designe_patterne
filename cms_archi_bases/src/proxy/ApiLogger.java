package proxy;

import ensisa.Page;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

public class ApiLogger extends Logger {

    private HttpClient client;

    public ApiLogger(Siteable proxyed) {
        super(proxyed);
        this.client = HttpClient.newHttpClient();
    }

    @Override
    public void apply(Page p) {

        String json = """
                {
                    "date": "%s",
                    "action": "Ajout de la Page:",
                    "page": "%s"
                }
                """.formatted(LocalDateTime.now(), p.getTitle());

        try {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://webhook.site/94e2c495-15b4-4371-a235-f1a4973d899a"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
