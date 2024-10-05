package com.GWAMINC.booking_be.dto;

import com.GWAMINC.booking_be.entity.Location;
import com.GWAMINC.booking_be.entity.PlaceType;
import com.GWAMINC.booking_be.entity.Property;
import com.GWAMINC.booking_be.entity.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyAttributeDto {
    private Long id;
    private PropertyDto property;
    private AttributeDto attribute;
}
