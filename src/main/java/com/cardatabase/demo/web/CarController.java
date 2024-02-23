package com.cardatabase.demo.web;

import com.cardatabase.demo.domain.Car;
import com.cardatabase.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarRepository repository;

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public Iterable<Car> getCars(){
        return repository.findAll();
    }

}
