package co.com.cattleya.ms.services.cart.application.config;

import co.com.cattleya.ms.services.cart.infrastructure.persistence.PaymentAPI;
import co.com.cattleya.ms.services.cart.infrastructure.persistence.api.PaymentApiConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Bean
    public PaymentAPI paymentAPI(){
        return new PaymentApiConsumer();
    }
}
