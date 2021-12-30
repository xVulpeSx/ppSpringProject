package com.spring.PP.service;

import com.spring.PP.db.model.Club;
import com.spring.PP.db.repo.ClubRepository;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ClubService extends GenericCRUDService<Club>{
    public ClubService(ClubRepository repository) {
        super(repository);
    }
}
