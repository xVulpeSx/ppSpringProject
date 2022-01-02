package com.spring.PP.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address implements AbstractData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String street;

    private int number;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Club club;
}
