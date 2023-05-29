package co.com.cattleya.ms.services.service.infrastructure.persistence.api;

import co.com.cattleya.ms.services.service.domain.model.WeatherInfo;
import co.com.cattleya.ms.services.service.infrastructure.persistence.WeatherServiceAPI;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Service

public class WheaterService implements WeatherServiceAPI {

    private static final String API_KEY = "811eb8f64f7b4cc19f840456232905";

    @Override
    public WeatherInfo getWeather(String location) throws IOException, InterruptedException {
        String url = String.format("http://api.weatherapi.com/v1/current.json?key=%s&q=%s&aqi=no&lang=es&emp_c=1", API_KEY, location);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = response.body();

        // Parse JSON response
        JSONObject json = new JSONObject(responseBody);
        System.out.println(json);
        String weatherDescription = json.getJSONObject("current").getJSONObject("condition").getString("text");
        String empC = json.getJSONObject("current").getDouble("temp_c") + "°C";
        int humidity = json.getJSONObject("current").getInt("humidity");
        String localtime = json.getJSONObject("location").getString("localtime");

        WeatherInfo weatherInfo = new WeatherInfo();
        System.out.println(weatherDescription);
        System.out.println(empC);
        System.out.println(humidity);
        System.out.println(localtime);

        weatherInfo.setWheater(weatherDescription);
        weatherInfo.setEmpC(empC);
        weatherInfo.setHumidity(humidity);
        weatherInfo.setLocaltime(localtime);

        return weatherInfo;
    }

}
