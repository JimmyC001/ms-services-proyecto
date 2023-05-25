package co.com.cattleya.ms.services.question.presentation.controller;

import co.com.cattleya.ms.services.question.domain.model.Question;
import co.com.cattleya.ms.services.question.domain.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("service")
public class DeleteQuestionController {
    private final QuestionService service;
    @Autowired
    public DeleteQuestionController(QuestionService service){
        this.service = service;
    }
    @DeleteMapping("{sId}/question/{qId}")
    public ResponseEntity<Question> deleteQuestion(@PathVariable("sId") Long sId, @PathVariable("qId") Long qId){
        if(sId == null || qId == null)
            return ResponseEntity.badRequest().build();
        List<Question> questions = service.getByService(sId);
        if(questions == null || questions.isEmpty())
            return ResponseEntity.badRequest().build();
        Question deleted = service.deleteQuestion(qId);
        if(deleted == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(deleted);
    }
}
