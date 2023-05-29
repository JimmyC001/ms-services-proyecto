package co.com.cattleya.ms.services.service.application.config;

import co.com.cattleya.ms.services.service.infrastructure.persistence.CountryServiceAPI;
import co.com.cattleya.ms.services.service.infrastructure.persistence.WeatherServiceAPI;
import co.com.cattleya.ms.services.service.infrastructure.persistence.api.CountryService;
import co.com.cattleya.ms.services.service.infrastructure.persistence.api.WheaterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class WebConfig {
    @Bean

    public CountryServiceAPI countryServiceApi(){
        return new CountryService();
    }
    @Bean
    public WeatherServiceAPI weatherServiceAPI(){
        return new WheaterService();
    }
}
