package co.com.cattleya.ms.services.service.application.config;

import co.com.cattleya.ms.services.service.infrastructure.persistence.CountryServiceAPI;
import co.com.cattleya.ms.services.service.infrastructure.persistence.api.CountryService;
import org.springframework.context.annotation.Bean;

public class WebConfig {
    @Bean

    public CountryServiceAPI countryServiceApi(){
        return new CountryService();
    }
}
