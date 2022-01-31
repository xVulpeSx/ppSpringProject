package com.spring.PP.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "coach")
    @JsonIgnore
    private Club club;
}
