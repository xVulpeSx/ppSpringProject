package com.spring.PP.service;

import com.spring.PP.db.model.Address;
import com.spring.PP.db.repo.AddressRepository;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends  GenericCRUDService<Address> {
    public AddressService(AddressRepository repository) {
        super(repository);
    }
}
