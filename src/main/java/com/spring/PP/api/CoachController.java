package com.spring.PP.api;

import com.spring.PP.db.model.Coach;
import com.spring.PP.service.CoachService;
import com.spring.PP.service.GenericCRUDService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coach")
public class CoachController extends GenericCRUDController<Coach>{
    public CoachController(CoachService service) {
        super(service);
    }
}
