package co.com.cattleya.ms.services.rating.presentation.controller;



import co.com.cattleya.ms.services.rating.application.dto.post.PostRatingRequest;
import co.com.cattleya.ms.services.rating.application.mapper.PostRatingMapper;
import co.com.cattleya.ms.services.rating.domain.model.Rating;
import co.com.cattleya.ms.services.rating.domain.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("service")
public class PostRatingController {

    private final RatingService service;
    private final PostRatingMapper mapper;

    @Autowired
    public PostRatingController(RatingService service, PostRatingMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("{id}/rating")
    public ResponseEntity<Rating> createRating(@PathVariable Long id, @RequestBody PostRatingRequest request){
        if(id == null || request.getUserid() == null || request.getPoints() == null)
            return ResponseEntity.badRequest().build();
        if(!id.equals(request.getService()))
            return ResponseEntity.status(303).build();
        Rating rating = mapper.toRating(request);
        if(rating == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(service.saveRating(rating));
    }
}
