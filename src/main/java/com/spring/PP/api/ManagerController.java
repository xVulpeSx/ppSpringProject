package com.spring.PP.api;

import com.spring.PP.db.model.Manager;
import com.spring.PP.service.GenericCRUDService;
import com.spring.PP.service.ManagerService;
import lombok.experimental.SuperBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerController extends GenericCRUDController<Manager> {
    public ManagerController(ManagerService service) {
        super(service);
    }
}
