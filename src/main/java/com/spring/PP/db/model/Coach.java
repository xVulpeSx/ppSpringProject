package com.spring.PP.db.model;

import javax.persistence.*;

@Entity
@Table(name="coaches")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "coach")
    private Club club;
}
