package com.spring.PP.service;

import com.spring.PP.db.model.Player;
import com.spring.PP.db.repo.PlayerRepository;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService extends GenericCRUDService<Player>{
    public PlayerService(PlayerRepository repository) {
        super(repository);
    }
}
