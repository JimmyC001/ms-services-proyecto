package co.com.cattleya.ms.services.rating.application.dto.post;


import lombok.Data;

@Data
public class PostRatingRequest {
    private Long points;
    private String description;
    private Long userid;
    private Long service;

}
