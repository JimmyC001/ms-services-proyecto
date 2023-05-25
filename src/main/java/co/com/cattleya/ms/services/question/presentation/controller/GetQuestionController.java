package co.com.cattleya.ms.services.question.presentation.controller;

import co.com.cattleya.ms.services.question.domain.model.Question;
import co.com.cattleya.ms.services.question.domain.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("service")
public class GetQuestionController {
    private final QuestionService service;
    @Autowired
    public GetQuestionController(QuestionService service){
        this.service = service;
    }
    @GetMapping("{id}/question")
    public ResponseEntity<List<Question>> getAllQuestion(@PathVariable Long id){
        if(id == null)
            return ResponseEntity.badRequest().build();
        List<Question> questions = service.getByService(id);
        if(questions == null)
            return ResponseEntity.badRequest().build();
        if(questions.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(questions);
    }
}
