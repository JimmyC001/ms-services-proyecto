package co.com.cattleya.ms.services.question.application.mapper;

import co.com.cattleya.ms.services.question.application.dto.post.PostQuestionRequest;
import co.com.cattleya.ms.services.question.domain.model.Question;
import co.com.cattleya.ms.services.service.domain.model.Service;
import co.com.cattleya.ms.services.service.domain.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostQuestionMapper {
    @Autowired
    private ServiceRepository serviceRepository;
    public Question toQuestion(PostQuestionRequest request){
        Service service = serviceRepository.findById(request.getService()).orElse(null);
        if(service == null)
            return null;
        return Question.builder()
                .question(request.getQuestion())
                .response(null)
                .service(service)
        .build();
    }
}
