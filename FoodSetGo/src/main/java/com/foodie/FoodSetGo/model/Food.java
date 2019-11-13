package com.foodie.FoodSetGo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class
Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String description;
}
