package com.GWAMINC.booking_be.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nightly_price")
    private float nightly_price;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "num_guests")
    private int num_guests;

    @Column(name = "num_bedrooms")
    private int num_bedrooms;

    @Column(name = "num_beds")
    private int num_beds;

    @Column(name = "num_baths")
    private int num_baths;

    @Column(name = "is_guest_favorite")
    private boolean is_guest_favorite;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "place_type_id")
    private PlaceType placeType;

    @ManyToOne
    @JoinColumn(name = "property_type_id")
    private PropertyType propertyType;
}
