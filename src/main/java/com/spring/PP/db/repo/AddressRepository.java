package com.spring.PP.db.repo;

import com.spring.PP.db.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
