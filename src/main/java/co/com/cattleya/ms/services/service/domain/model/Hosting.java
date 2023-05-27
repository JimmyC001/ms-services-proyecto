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
@DiscriminatorValue("hosting")
public class Hosting extends Service{
    private String place;
    private Integer days;
    private String country;
}
