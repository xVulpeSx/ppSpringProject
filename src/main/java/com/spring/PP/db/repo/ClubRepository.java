package com.spring.PP.db.repo;

import com.spring.PP.db.model.Club;
import com.spring.PP.exception.MissingEntityException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

//    @Query("SELECT c FROM CLUBS c WHERE c.name=:name")
//    Club customQueryFindByName(@Param("name")String name);

    List<Club> findAllByName(String name);
    Club findByAddressId(Long id) throws MissingEntityException;
}
