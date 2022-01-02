package com.spring.PP.db.dto;

import com.spring.PP.db.model.AbstractData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDto{
    private String street;

    private int number;

    private Long club;
}
