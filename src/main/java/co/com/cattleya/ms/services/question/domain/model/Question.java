package co.com.cattleya.ms.services.question.domain.model;

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
@Entity(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String question;
    private String response;
    @ManyToOne(optional = false)
    @JsonIgnore
    private Service service;
}
