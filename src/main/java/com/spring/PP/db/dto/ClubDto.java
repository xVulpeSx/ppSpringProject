package com.spring.PP.db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClubDto {
    private String name;

    private Long address;

    private Long coach;

    private List<Long> team;
}
