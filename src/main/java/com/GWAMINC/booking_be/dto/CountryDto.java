package com.GWAMINC.booking_be.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {
    private Long id;
    private String name;
    private RegionDto region;
}
