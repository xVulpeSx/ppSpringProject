package com.spring.PP.db.repo;

import com.spring.PP.db.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

//    @Query("SELECT c FROM CLUBS c WHERE c.coach_id=:id")
//    Club customQueryFindByCoachId(@Param("id")Long id);

    Club findByName(String name);
    Club findByAddressId(Long id);
}
