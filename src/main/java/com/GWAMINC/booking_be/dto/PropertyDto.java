package com.GWAMINC.booking_be.dto;

import com.GWAMINC.booking_be.entity.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto {
    private Long id;
    private String propertyName;
    private LocationDto location;
    private PlaceTypeDto placeType;
    private PropertyTypeDto propertyType;
    private Double nightlyPrice;
    private Integer numGuests;
    private Integer numBeds;
    private Integer numBedrooms;
    private Integer numBathrooms;
    private Boolean isGuestFavourite;
    private String description;
    private String addressLine1;
    private String addressLine2;
    private UserAccount host;
}
