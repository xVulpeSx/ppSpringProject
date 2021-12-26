package com.spring.PP.db.repo;

import com.spring.PP.db.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
