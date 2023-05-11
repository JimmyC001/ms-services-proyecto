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
@DiscriminatorValue("ecotour")
public class EcoTrip extends Service{
    private String origin;
    private String destination;
    private String activities;
}
