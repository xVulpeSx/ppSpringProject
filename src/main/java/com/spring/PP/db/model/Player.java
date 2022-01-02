package com.spring.PP.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player implements AbstractData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "club_id")
    @JsonIgnore
    private Club club;

    @ManyToOne
    @JoinColumn(name="manager_id", nullable = false)
    @JsonIgnore
    private Manager manager;
}
