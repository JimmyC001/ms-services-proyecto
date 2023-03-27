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
@DiscriminatorValue("hosting")
public class Hosting extends Service{
    private String place;
    private Integer days;
}
