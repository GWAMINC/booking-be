package com.GWAMINC.booking_be.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "component_rating")
public class ComponentRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "component_id")
    private ReviewComponent component;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private UserReview review;

    @Column(name = "rating")
    private Integer rating;
}
