package co.com.cattleya.ms.services.cart.application.dto.put;

import lombok.Data;

import java.util.List;

@Data
public class PutCartRequest {
    private List<String> offers;
}
