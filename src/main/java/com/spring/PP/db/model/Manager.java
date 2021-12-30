package com.spring.PP.db.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "managers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Manager implements AbstractData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "manager")
    private List<Player> players;
}
