package co.com.cattleya.ms.services.service.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("food")
public class Food extends Service{
    private boolean vegan;
    private Double kcal;
}
