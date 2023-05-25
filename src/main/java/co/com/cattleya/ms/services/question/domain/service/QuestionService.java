package co.com.cattleya.ms.services.question.domain.service;

import co.com.cattleya.ms.services.question.domain.model.Question;
import co.com.cattleya.ms.services.question.domain.repository.QuestionRepository;
import co.com.cattleya.ms.services.service.domain.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository repository;
    private final ServiceRepository serviceRepository;
    @Autowired
    public QuestionService(QuestionRepository repository, ServiceRepository serviceRepository){
        this.repository = repository;
        this.serviceRepository = serviceRepository;
    }
    public Question saveQuestion(Question question){
        Question dbQuestion = repository.findByQuestion(question.getQuestion()).orElse(null);
        if(dbQuestion != null)
            return dbQuestion;
        return repository.save(question);
    }
    public List<Question> getByService(Long serviceId){
        co.com.cattleya.ms.services.service.domain.model.Service service = serviceRepository.findById(serviceId).orElse(null);
        if(service == null)
            return null;
        return repository.findAllByService(service);
    }
    public Question deleteQuestion(Long id){
        Question dbQuestion = repository.findById(id).orElse(null);
        if (dbQuestion == null)
            return null;
        repository.delete(dbQuestion);
        return dbQuestion;
    }
}
