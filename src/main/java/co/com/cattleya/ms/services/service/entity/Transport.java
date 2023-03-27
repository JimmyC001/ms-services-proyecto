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
@DiscriminatorValue("transport")
public class Transport extends Service{
    private String company;
    private String vehicle;
    private String idVehicle;
    private String origin;
    private String destination;
}
