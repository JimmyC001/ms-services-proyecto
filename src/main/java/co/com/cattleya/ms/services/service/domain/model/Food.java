package co.com.cattleya.ms.services.service.domain.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
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
