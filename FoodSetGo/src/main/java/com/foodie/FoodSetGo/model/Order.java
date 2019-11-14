package com.foodie.FoodSetGo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "order_entity")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    @JoinTable(
            name = "order_food",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id"
            ))
    @JsonIgnore
    @Column(nullable = false)
    private List<Food> food;
    @Column(nullable = false)
    private Double totalPrice;
    @Column(nullable = false)
    private String deliveryAddress;

}
