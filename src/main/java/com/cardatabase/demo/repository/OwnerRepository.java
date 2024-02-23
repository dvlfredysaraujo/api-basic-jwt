package com.cardatabase.demo.repository;

import com.cardatabase.demo.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
