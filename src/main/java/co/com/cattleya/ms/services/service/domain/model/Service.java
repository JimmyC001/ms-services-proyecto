package co.com.cattleya.ms.services.service.domain.model;

import co.com.cattleya.ms.services.question.domain.model.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "service")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "type")
public abstract class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    private Double price;
    private String description;
    @Column(name = "provider_id", nullable = false)
    private Long providerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "service")
    private List<Question> questions;
}
