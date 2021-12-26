package com.spring.PP.db.model;

import javax.persistence.*;


@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String Street;

    private int number;

    @OneToOne(mappedBy = "address")
    private Club club;
}
