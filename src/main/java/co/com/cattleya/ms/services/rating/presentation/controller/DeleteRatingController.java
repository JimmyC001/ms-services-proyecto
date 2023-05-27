package co.com.cattleya.ms.services.rating.presentation.controller;

import co.com.cattleya.ms.services.question.domain.model.Question;
import co.com.cattleya.ms.services.question.domain.service.QuestionService;
import co.com.cattleya.ms.services.rating.domain.model.Rating;
import co.com.cattleya.ms.services.rating.domain.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("service")
public class DeleteRatingController {

    private final RatingService service;
    @Autowired
    public DeleteRatingController(RatingService service){
        this.service = service;
    }
    @DeleteMapping("{sId}/rating/{rId}")
    public ResponseEntity<Rating> deleteRating(@PathVariable("sId") Long sId, @PathVariable("rId") Long rId){
        if(sId == null || rId == null)
            return ResponseEntity.badRequest().build();
        List<Rating> rating = service.getByService(sId);
        if(rating == null || rating.isEmpty())
            return ResponseEntity.status(303).build();
        Rating deleted = service.deleteRating(rId);
        if(deleted == null)
            return ResponseEntity.status(304).build();
        return ResponseEntity.ok(deleted);
    }
}
