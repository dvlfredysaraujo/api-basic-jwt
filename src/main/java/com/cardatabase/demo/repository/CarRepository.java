package com.cardatabase.demo.repository;

import com.cardatabase.demo.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByBrand(@Param("brand") String brand);
}
