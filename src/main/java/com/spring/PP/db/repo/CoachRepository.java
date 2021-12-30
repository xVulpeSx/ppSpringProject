package com.spring.PP.db.repo;

import com.spring.PP.db.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
    List<Coach> findAllByName(String name);
}
