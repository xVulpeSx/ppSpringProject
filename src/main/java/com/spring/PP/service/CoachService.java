package com.spring.PP.service;

import com.spring.PP.db.model.Coach;
import com.spring.PP.db.repo.CoachRepository;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CoachService extends GenericCRUDService<Coach> {
    public CoachService(CoachRepository repository) {
        super(repository);
    }
}
