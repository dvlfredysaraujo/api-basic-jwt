package com.cardatabase.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand, model, color, registerNumber;
    private int iear, price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    @JsonIgnore
    private Owner owner;

    public Car(String brand, String model, String color, String registerNumber, int iear, int price, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.iear = iear;
        this.price = price;
        this.owner = owner;
    }

    public Car() {
    }
}
