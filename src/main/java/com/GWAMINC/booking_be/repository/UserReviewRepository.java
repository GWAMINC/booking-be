package com.GWAMINC.booking_be.repository;

import com.GWAMINC.booking_be.entity.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
}
