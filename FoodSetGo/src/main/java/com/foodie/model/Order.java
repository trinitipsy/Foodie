package com.foodie.model;

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
    @OneToMany(mappedBy = "order")
    @JsonIgnore
    @Column(nullable = false)
    private List<OrderItem> orderItem;
    @Column(nullable = false)
    private Double totalPrice;
    @Column(nullable = false)
    private String deliveryAddress;

}
