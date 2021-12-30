package com.spring.PP.api;

import com.spring.PP.db.model.Player;
import com.spring.PP.service.GenericCRUDService;
import com.spring.PP.service.PlayerService;
import lombok.experimental.SuperBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController extends GenericCRUDController<Player>{
    public PlayerController(PlayerService service) {
        super(service);
    }
}
