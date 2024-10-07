package com.GWAMINC.booking_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "user_review")
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount user;

    @Column(name = "overall_rating")
    private Integer overallRating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "review_date")
    @Temporal(TemporalType.DATE)
    private Date reviewDate;
}

