package com.spring.PP.db.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="coaches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coach implements AbstractData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "coach")
    private Club club;
}
