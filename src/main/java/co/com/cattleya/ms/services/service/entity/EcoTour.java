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
@DiscriminatorValue("ecotour")
public class EcoTour extends Service{
    private String origin;
    private String destination;
    private String activities;
}
