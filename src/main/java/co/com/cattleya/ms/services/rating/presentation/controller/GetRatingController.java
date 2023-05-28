package co.com.cattleya.ms.services.rating.presentation.controller;

import co.com.cattleya.ms.services.rating.domain.model.Rating;
import co.com.cattleya.ms.services.rating.domain.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("service")
public class GetRatingController {
    private final RatingService service;
    @Autowired
    public GetRatingController(RatingService service){
        this.service = service;
    }
    @GetMapping("{id}/rating")
    public ResponseEntity<List<Rating>> getAllRating(@PathVariable Long id){
        if(id == null)
            return ResponseEntity.badRequest().build();
        List<Rating> rating = service.getByService(id);
        if(rating == null)
            return ResponseEntity.badRequest().build();
        if(rating.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(rating);
    }
}
