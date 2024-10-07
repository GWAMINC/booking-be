package com.GWAMINC.booking_be.service.impl;

import com.GWAMINC.booking_be.dto.component_rating.ComponentRatingCreate;
import com.GWAMINC.booking_be.dto.component_rating.ComponentRatingResponse;
import com.GWAMINC.booking_be.dto.component_rating.ComponentRatingUpdate;
import com.GWAMINC.booking_be.dto.review_component.ReviewComponentCreate;
import com.GWAMINC.booking_be.dto.review_component.ReviewComponentResponse;
import com.GWAMINC.booking_be.dto.review_component.ReviewComponentUpdate;
import com.GWAMINC.booking_be.dto.user_review.UserReviewCreate;
import com.GWAMINC.booking_be.dto.user_review.UserReviewResponse;
import com.GWAMINC.booking_be.dto.user_review.UserReviewUpdate;
import com.GWAMINC.booking_be.entity.ComponentRating;
import com.GWAMINC.booking_be.entity.ReviewComponent;
import com.GWAMINC.booking_be.entity.UserReview;
import com.GWAMINC.booking_be.mapper.ComponentRatingMapper;
import com.GWAMINC.booking_be.mapper.ReviewComponentMapper;
import com.GWAMINC.booking_be.mapper.UserReviewMapper;
import com.GWAMINC.booking_be.repository.ComponentRatingRepository;
import com.GWAMINC.booking_be.repository.PropertyRepository;
import com.GWAMINC.booking_be.repository.ReviewComponentRepository;
import com.GWAMINC.booking_be.repository.UserReviewRepository;
import com.GWAMINC.booking_be.service.UserReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserReviewServiceImpl implements UserReviewService {

    private final UserReviewRepository userReviewRepository;
    private final PropertyRepository propertyRepository;
    private final ReviewComponentRepository reviewComponentRepository;
    private final ComponentRatingRepository componentRatingRepository;

    @Override
    public UserReviewResponse createUserReview(UserReviewCreate userReviewCreate) {
        var property = propertyRepository
                .findById(userReviewCreate.getPropertyId())
                .orElseThrow();

        UserReview userReview = UserReviewMapper.createToEntity(userReviewCreate);
        userReview.setProperty(property);

        UserReview savedUserReview = userReviewRepository.save(userReview);

        return UserReviewMapper.entityToResponse(savedUserReview);
    }

    @Override
    public UserReviewResponse getUserReviewById(long id) {
        UserReview result = userReviewRepository
                .findById(id)
                .orElseThrow();

        return UserReviewMapper.entityToResponse(result);
    }

    @Override
    public UserReviewResponse updateUserReview(long id, UserReviewUpdate userReviewUpdate) {
        var userReview = userReviewRepository
                .findById(id)
                .orElseThrow();

        UserReviewMapper.updateToEntity(userReview, userReviewUpdate);

        UserReview savedUserReview = userReviewRepository.save(userReview);
        return UserReviewMapper.entityToResponse(savedUserReview);
    }

    @Override
    public void deleteUserReview(long id) {
        UserReview userReview = userReviewRepository
                .findById(id)
                .orElseThrow();

        userReviewRepository.delete(userReview);
    }

    @Override
    public List<UserReviewResponse> listUserReviews() {
        return userReviewRepository
                .findAll()
                .stream()
                .map(UserReviewMapper::entityToResponse)
                .toList();
    }

    @Override
    public ReviewComponentResponse createReviewComponent(ReviewComponentCreate reviewComponentCreate) {
        var reviewComponent = ReviewComponentMapper.createToEntity(reviewComponentCreate);
        var savedReviewComponent = reviewComponentRepository.save(reviewComponent);
        return ReviewComponentMapper.entityToResponse(savedReviewComponent);
    }

    @Override
    public ReviewComponentResponse updateReviewComponent(Long id, ReviewComponentUpdate reviewComponentUpdate) {
        var reviewComponent = reviewComponentRepository
                .findById(id)
                .orElseThrow();

        ReviewComponentMapper.updateToEntity(reviewComponent, reviewComponentUpdate);

        var savedReviewComponent = reviewComponentRepository.save(reviewComponent);

        return ReviewComponentMapper.entityToResponse(savedReviewComponent);
    }

    @Override
    public ReviewComponentResponse getReviewComponentById(Long id) {
        ReviewComponent reviewComponent = reviewComponentRepository
                .findById(id)
                .orElseThrow();

        return ReviewComponentMapper.entityToResponse(reviewComponent);
    }

    @Override
    public void deleteReviewComponentById(Long id) {
        ReviewComponent reviewComponent = reviewComponentRepository
                .findById(id)
                .orElseThrow();

        reviewComponentRepository.deleteById(id);
    }

    @Override
    public List<ReviewComponentResponse> listReviewComponent() {
        return reviewComponentRepository.findAll()
                .stream()
                .map(ReviewComponentMapper::entityToResponse)
                .toList();
    }

    @Override
    public ComponentRatingResponse createComponentRating(ComponentRatingCreate componentRatingCreate) {
        var userReview = userReviewRepository
                .findById(componentRatingCreate.getReviewId())
                .orElseThrow();

        var reviewComponent = reviewComponentRepository
                .findById(componentRatingCreate.getComponentId())
                .orElseThrow();

        ComponentRating componentRating = ComponentRatingMapper.createToEntity(componentRatingCreate);
        componentRating.setReview(userReview);
        componentRating.setComponent(reviewComponent);

        return ComponentRatingMapper.entityToResponse(componentRatingRepository.save(componentRating));
    }

    @Override
    public ComponentRatingResponse updateComponentRating(Long id, ComponentRatingUpdate componentRatingUpdate) {
        var componentRating = componentRatingRepository
                .findById(id)
                .orElseThrow();

        ComponentRatingMapper.updateToEntity(componentRating, componentRatingUpdate);

        var savedComponentRating = componentRatingRepository.save(componentRating);
        return ComponentRatingMapper.entityToResponse(savedComponentRating);
    }

    @Override
    public ComponentRatingResponse getComponentRatingById(Long id) {
        var componentRating = componentRatingRepository
                .findById(id)
                .orElseThrow();

        return ComponentRatingMapper.entityToResponse(componentRating);
    }

    @Override
    public void deleteComponentRatingById(Long id) {
        var componentRating = componentRatingRepository
                .findById(id)
                .orElseThrow();

        componentRatingRepository.delete(componentRating);
    }

    @Override
    public List<ComponentRatingResponse> listComponentRating() {
        return componentRatingRepository
                .findAll()
                .stream()
                .map(ComponentRatingMapper::entityToResponse)
                .toList();
    }

}
