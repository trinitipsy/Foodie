package com.foodie.FoodSetGo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore
    private Restaurant restaurant;
    @ManyToMany(mappedBy = "food")
    @JsonIgnore
    private List<Order> order;
}
