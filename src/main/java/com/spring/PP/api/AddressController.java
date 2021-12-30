package com.spring.PP.api;

import com.spring.PP.db.model.Address;
import com.spring.PP.service.AddressService;
import com.spring.PP.service.GenericCRUDService;
import lombok.experimental.SuperBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController extends GenericCRUDController<Address>{

    public AddressController(AddressService service) {
        super(service);
    }
}
