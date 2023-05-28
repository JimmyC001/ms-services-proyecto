package co.com.cattleya.ms.services.cart.domain.model;

import co.com.cattleya.ms.services.offer.domain.model.Offer;
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
@Entity(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private Long clientId;
    private String status;
    private Double price;
    @OneToMany
    private List<Offer> services;
}
