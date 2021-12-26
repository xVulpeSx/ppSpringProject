package com.spring.PP.db.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clubs")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name="address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne
    @JoinColumn(name="coach_id", referencedColumnName = "id")
    private Coach coach;

    @OneToMany(mappedBy = "club")
    private List<Player> team;

}
