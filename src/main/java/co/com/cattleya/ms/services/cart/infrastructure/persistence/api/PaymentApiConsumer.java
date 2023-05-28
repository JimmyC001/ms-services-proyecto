package co.com.cattleya.ms.services.cart.infrastructure.persistence.api;

import co.com.cattleya.ms.services.cart.infrastructure.persistence.PaymentAPI;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class PaymentApiConsumer implements PaymentAPI {
    private final String API_URL = "http://payment:9000/pay";
    public boolean pay(Long id, Double amount) throws IOException {
        URL url = new URL(API_URL + "/sub");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        // Set Body
        String body = "{\"client_id\":" + id + ",\"amount\":" + amount + "}";
        OutputStream output = connection.getOutputStream();
        output.write(body.getBytes());
        output.flush();
        output.close();
        return connection.getResponseCode() == 200;
    }
    public boolean create(Long id) throws IOException {
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        // Set Body
        String body = "{\"client_id\":" + id + ",\"amount\":1000000000}";
        OutputStream output = connection.getOutputStream();
        output.write(body.getBytes());
        output.flush();
        output.close();
        return connection.getResponseCode() == 200;
    }
}
