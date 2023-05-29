package co.com.cattleya.ms.services.service.infrastructure.persistence;

import co.com.cattleya.ms.services.service.domain.model.WeatherInfo;

import java.io.IOException;

public interface WeatherServiceAPI {

    WeatherInfo getWeather (String location) throws IOException, InterruptedException;
}
