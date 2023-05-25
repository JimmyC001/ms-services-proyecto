package co.com.cattleya.ms.services.question.presentation.controller;

import co.com.cattleya.ms.services.question.application.dto.post.PostQuestionRequest;
import co.com.cattleya.ms.services.question.application.mapper.PostQuestionMapper;
import co.com.cattleya.ms.services.question.domain.model.Question;
import co.com.cattleya.ms.services.question.domain.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("service")
public class PostQuestionController {
    private final QuestionService service;
    private final PostQuestionMapper mapper;
    @Autowired
    public PostQuestionController(QuestionService service, PostQuestionMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }
    @PostMapping("{id}/question")
    public ResponseEntity<Question> createQuestion(@PathVariable Long id, @RequestBody PostQuestionRequest request){
        if(id == null || request.getQuestion() == null || request.getService() == null)
            return ResponseEntity.badRequest().build();
        if(!id.equals(request.getService()))
            return ResponseEntity.badRequest().build();
        Question question = mapper.toQuestion(request);
        if(question == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(service.saveQuestion(question));
    }
}
