package com.foodie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer amount;
    @Column
    private Double price;
    @ManyToOne
    @JsonIgnore
    private Food food;
    @ManyToOne
    @JsonIgnore
    private Order order;

    public OrderItem(final Food food, final Integer amount, final Order order, final Double price) {
        this.amount = amount;
        this.food = food;
        this.order = order;
        this.price = price;
    }
}
