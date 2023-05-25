package co.com.cattleya.ms.services.question.domain.repository;


import co.com.cattleya.ms.services.question.domain.model.Question;
import co.com.cattleya.ms.services.service.domain.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findByQuestion(String question);
    List<Question> findAllByService(Service service);
}
