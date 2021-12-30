package com.spring.PP.api;

import com.spring.PP.db.model.Club;
import com.spring.PP.service.ClubService;
import com.spring.PP.service.GenericCRUDService;
import lombok.experimental.SuperBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/club")
public class ClubController extends GenericCRUDController<Club>{
    public ClubController(ClubService service) {
        super(service);
    }
}
