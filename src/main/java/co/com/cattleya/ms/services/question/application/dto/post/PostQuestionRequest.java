package co.com.cattleya.ms.services.question.application.dto.post;

import lombok.Data;

@Data
public class PostQuestionRequest {
    private String question;
    private Long service;
}
