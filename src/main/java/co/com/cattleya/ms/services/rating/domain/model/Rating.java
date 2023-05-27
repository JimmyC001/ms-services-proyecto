package co.com.cattleya.ms.services.rating.domain.model;

import co.com.cattleya.ms.services.service.domain.model.Service;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Long points;
    private String description;
    private Long userid;
    @ManyToOne(optional = false)
    @JsonIgnore
    private Service service;

}
