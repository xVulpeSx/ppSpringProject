package com.spring.PP.db.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "manager")
    private List<Player> players;

}
