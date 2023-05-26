package co.com.cattleya.ms.services.service.infrastructure.persistence.api;

import co.com.cattleya.ms.services.service.domain.model.CountryInfo;
import co.com.cattleya.ms.services.service.infrastructure.persistence.CountryServiceAPI;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class CountryService implements CountryServiceAPI {

    @Override

    public CountryInfo getCountryInfo(String countryName) throws Exception {
        try {
            // URL of the API endpoint you want to send the GET request to
            String apiUrl = "https://restcountries.com/v3.1/name/" + countryName + "?fields=capital,,currencies,latlng,maps";
            ObjectMapper objectMapper = new ObjectMapper();
            // Create a URL object with the API endpoint
            URL url = new URL(apiUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Get the response code from the server
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Print the response
            System.out.println("Response Body: " + response.toString());
            List<CountryInfo> countries = objectMapper.readValue(response.toString(), new TypeReference<>() {});
            // Disconnect the connection
            connection.disconnect();
            return countries.get(0);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

