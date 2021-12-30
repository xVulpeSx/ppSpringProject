package com.spring.PP.service;

import com.spring.PP.db.model.Manager;
import com.spring.PP.db.repo.ManagerRepository;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ManagerService extends GenericCRUDService<Manager> {
    public ManagerService(ManagerRepository repository) {
        super(repository);
    }
}
