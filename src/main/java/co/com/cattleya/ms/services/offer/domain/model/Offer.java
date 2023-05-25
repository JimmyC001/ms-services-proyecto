package co.com.cattleya.ms.services.offer.domain.model;

import co.com.cattleya.ms.services.service.domain.model.Service;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long providerId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Service> services;
}
