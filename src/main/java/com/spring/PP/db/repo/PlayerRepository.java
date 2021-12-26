package com.spring.PP.db.repo;

import com.spring.PP.db.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
