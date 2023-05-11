package co.com.cattleya.ms.services.service.presentation.controller;


import co.com.cattleya.ms.services.service.application.dto.post.PostServiceRequest;
import co.com.cattleya.ms.services.service.application.dto.post.PostServiceResponse;
import co.com.cattleya.ms.services.service.application.mapper.PostServiceMapper;
import co.com.cattleya.ms.services.service.domain.model.Service;
import co.com.cattleya.ms.services.service.domain.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("service")
public class PostServiceController {
    private final ServiceService service;
    private final PostServiceMapper mapper = new PostServiceMapper();
    @Autowired
    public PostServiceController(ServiceService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<PostServiceResponse> create(@RequestBody PostServiceRequest request) {
        if (request == null)
            return ResponseEntity.badRequest().build();
        Service toSave = mapper.toService(request);
        if(toSave == null)
            return ResponseEntity.badRequest().build();
        Service founded = service.saveService(toSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(founded, request.getType()));
    }
}
