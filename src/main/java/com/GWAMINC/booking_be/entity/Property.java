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

    @Column(name = "property_name")
    private String propertyName;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "place_type_id")
    private PlaceType placeType;

    @ManyToOne
    @JoinColumn(name = "property_type_id")
    private PropertyType propertyType;

    @Column(name = "nightly_price")
    private Double nightlyPrice;

    @Column(name = "num_guests")
    private Integer numGuests;

    @Column(name = "num_beds")
    private Integer numBeds;

    @Column(name = "num_bedrooms")
    private Integer numBedrooms;

    @Column(name = "num_bathrooms")
    private Integer numBathrooms;

    @Column(name = "is_guest_favourite")
    private Boolean isGuestFavourite;

    @Column(name = "description")
    private String description;

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private UserAccount host;
}
