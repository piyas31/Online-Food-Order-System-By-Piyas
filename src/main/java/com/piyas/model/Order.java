package com.piyas.model;


import jakarta.persistence.*;

@Entity

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User customer;

    private Restaurant restaurant;

}

