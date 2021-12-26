package com.spring.PP.db.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "managers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Manager{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "manager")
    private List<Player> players;

}
