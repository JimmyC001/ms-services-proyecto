package co.com.cattleya.ms.services.cart.infrastructure.persistence;

import java.io.IOException;

public interface PaymentAPI {
    boolean pay(Long id, Double amount) throws IOException;
    boolean create(Long id) throws IOException;
}
