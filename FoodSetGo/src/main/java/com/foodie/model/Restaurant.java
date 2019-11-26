package com.foodie.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Boolean active;
    // TODO napraviti getter da dovlaci samo aktivnu hranu
    @OneToMany(mappedBy = "restaurant")
    private List<Food> menu;
}
