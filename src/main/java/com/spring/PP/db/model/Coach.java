package com.spring.PP.db.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="coaches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coach{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "coach")
    private Club club;
}
