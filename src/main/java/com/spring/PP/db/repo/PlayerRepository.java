package com.spring.PP.db.repo;

import com.spring.PP.db.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findAllByManagerId(Long managerId);
}
