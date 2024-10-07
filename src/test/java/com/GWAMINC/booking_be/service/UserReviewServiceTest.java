package com.GWAMINC.booking_be.service;

import com.GWAMINC.booking_be.dto.review_component.ReviewComponentCreate;
import com.GWAMINC.booking_be.dto.review_component.ReviewComponentResponse;
import com.GWAMINC.booking_be.dto.review_component.ReviewComponentUpdate;
import com.GWAMINC.booking_be.dto.user_review.UserReviewCreate;
import com.GWAMINC.booking_be.dto.user_review.UserReviewResponse;
import com.GWAMINC.booking_be.dto.user_review.UserReviewUpdate;
import com.GWAMINC.booking_be.entity.Property;
import com.GWAMINC.booking_be.entity.ReviewComponent;
import com.GWAMINC.booking_be.entity.UserReview;
import com.GWAMINC.booking_be.mapper.ReviewComponentMapper;
import com.GWAMINC.booking_be.mapper.UserReviewMapper;
import com.GWAMINC.booking_be.repository.PropertyRepository;
import com.GWAMINC.booking_be.repository.ReviewComponentRepository;
import com.GWAMINC.booking_be.repository.UserReviewRepository;
import com.GWAMINC.booking_be.service.impl.UserReviewServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserReviewServiceTest {

    @Mock
    UserReviewRepository userReviewRepository;

    @Mock
    PropertyRepository propertyRepository;

    @Mock
    private ReviewComponentRepository reviewComponentRepository;

    @InjectMocks
    UserReviewServiceImpl userReviewService;

    @Test
    void testCreateUserReviewSuccessfully() {
        UserReviewCreate userReviewCreate = UserReviewCreate.builder()
                .comment("comment")
                .overallRating(1)
                .propertyId(1L)
                .propertyId(1L)
                .build();

        Property property = Property.builder()
                .id(1L)
                .addressLine1("address line 1")
                .addressLine2("address line 2")
                .build();

        UserReview userReview = UserReviewMapper.createToEntity(userReviewCreate);

        when(userReviewRepository.save(any(UserReview.class))).thenReturn(userReview);
        when(propertyRepository.findById(any())).thenReturn(Optional.of(property));

        UserReviewResponse savedUserReview = userReviewService.createUserReview(userReviewCreate);

        assertThat(savedUserReview.getComment()).isEqualTo(userReview.getComment());
        assertThat(savedUserReview.getOverallRating()).isEqualTo(userReview.getOverallRating());

        verify(userReviewRepository).save(any(UserReview.class));
    }

    @Test
    void testListUserReviewSuccessfully() {
        Long id = 1L;
        UserReview userReview = UserReview.builder()
                .id(id)
                .comment("comment")
                .overallRating(1)
                .build();

        when(userReviewRepository.findById(id)).thenReturn(Optional.of(userReview));

        UserReviewResponse result = userReviewService.getUserReviewById(id);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
        assertThat(result.getComment()).isEqualTo(userReview.getComment());
        assertThat(result.getOverallRating()).isEqualTo(userReview.getOverallRating());

        verify(userReviewRepository).findById(id);
    }

    @Test
    void testUpdateUserReviewSuccessfully() {
        long id = 1L;

        UserReview oldUserReview = UserReview.builder()
                .id(id)
                .comment("old comment")
                .overallRating(1)
                .build();

        UserReviewUpdate userReviewUpdate = UserReviewUpdate.builder()
                .comment("new comment")
                .overallRating(2)
                .build();

        when(userReviewRepository.findById(id)).thenReturn(Optional.of(oldUserReview));
        when(userReviewRepository.save(any(UserReview.class))).thenReturn(oldUserReview);

        UserReviewResponse result = userReviewService.updateUserReview(id, userReviewUpdate);
        UserReviewResponse response = UserReviewMapper.entityToResponse(oldUserReview);

        verify(userReviewRepository).findById(id);
        verify(userReviewRepository).save(oldUserReview);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(response);
        assertThat(result.getComment()).isEqualTo(oldUserReview.getComment());
        assertThat(result.getOverallRating()).isEqualTo(oldUserReview.getOverallRating());
    }

    @Test
    void testDeleteUserReviewSuccessfully() {
        long id = 1L;

        UserReview userReview = UserReview.builder()
                .id(id)
                .comment("old comment")
                .overallRating(1)
                .build();

        when(userReviewRepository.findById(id)).thenReturn(Optional.of(userReview));

        userReviewService.deleteUserReview(id);

        verify(userReviewRepository).findById(id);
        verify(userReviewRepository).delete(userReview);
    }

    @Test
    void testListUserReview() {
        UserReview userReview1 = UserReview.builder()
                .id(1L)
                .comment("old comment")
                .overallRating(1)
                .build();

        UserReview userReview2 = UserReview.builder()
                .id(2L)
                .comment("old comment")
                .overallRating(1)
                .build();

        UserReview userReview3 = UserReview.builder()
                .id(3L)
                .comment("old comment")
                .overallRating(1)
                .build();

        List<UserReview> userReviews = List.of(
                userReview1,
                userReview2,
                userReview3
        );

        when(userReviewRepository.findAll()).thenReturn(userReviews);

        List<UserReviewResponse> result = userReviewService.listUserReviews();
        verify(userReviewRepository).findAll();

        assertThat(result.size()).isEqualTo(3);

        assertThat(result.get(0)).isEqualTo(UserReviewMapper.entityToResponse(userReview1));
        assertThat(result.get(1)).isEqualTo(UserReviewMapper.entityToResponse(userReview2));
        assertThat(result.get(2)).isEqualTo(UserReviewMapper.entityToResponse(userReview3));
    }

    @Test
    void testCreateReviewComponentSuccessfully() {
        ReviewComponentCreate reviewComponentCreate = ReviewComponentCreate.builder()
                .componentName("name")
                .build();

        ReviewComponent reviewComponent = ReviewComponentMapper.createToEntity(reviewComponentCreate);

        when(reviewComponentRepository.save(any(ReviewComponent.class))).thenReturn(reviewComponent);

        ReviewComponentResponse actualResponse = userReviewService.createReviewComponent(reviewComponentCreate);

        verify(reviewComponentRepository).save(any(ReviewComponent.class));

        assert(actualResponse.getComponentName().equals(reviewComponentCreate.getComponentName()));
    }

    @Test
    void testUpdateReviewComponentSuccessfully() {
        Long id = 1L;

        ReviewComponent reviewComponent = ReviewComponent.builder()
                .id(id)
                .componentName("name")
                .build();

        ReviewComponentUpdate reviewComponentUpdate = ReviewComponentUpdate
                .builder()
                .componentName("new name")
                .build();

        when(reviewComponentRepository.findById(id)).thenReturn(Optional.of(reviewComponent));
        when(reviewComponentRepository.save(any(ReviewComponent.class))).thenReturn(reviewComponent);

        ReviewComponentResponse actualResponse = userReviewService.updateReviewComponent(id, reviewComponentUpdate);

        verify(reviewComponentRepository).findById(id);
        verify(reviewComponentRepository).save(reviewComponent);

        assertThat(actualResponse.getComponentName()).isEqualTo(reviewComponentUpdate.getComponentName());
    }

    @Test
    void testGetReviewComponentSuccessfully() {
        Long id = 1L;

        ReviewComponent reviewComponent = ReviewComponent.builder()
                .id(id)
                .componentName("name")
                .build();

        when(reviewComponentRepository.findById(id)).thenReturn(Optional.of(reviewComponent));
        ReviewComponentResponse actualResponse = userReviewService.getReviewComponentById(id);
        verify(reviewComponentRepository).findById(id);
        assertThat(actualResponse.getComponentName()).isEqualTo(reviewComponent.getComponentName());
        assertThat(actualResponse.getId()).isEqualTo(id);
    }

    @Test
    void testDeleteReviewComponentSuccessfully() {
        Long id = 1L;

        ReviewComponent reviewComponent = ReviewComponent.builder()
                .id(id)
                .componentName("name")
                .build();

        when(reviewComponentRepository.findById(id)).thenReturn(Optional.of(reviewComponent));

        userReviewService.deleteReviewComponentById(id);

        verify(reviewComponentRepository).findById(id);
    }

    @Test
    void testListReviewComponentSuccessfully() {
        ReviewComponent reviewComponent1 = ReviewComponent.builder()
                .id(1L)
                .componentName("name")
                .build();
        ReviewComponent reviewComponent2 = ReviewComponent.builder()
                .id(2L)
                .componentName("name")
                .build();
        ReviewComponent reviewComponent3 = ReviewComponent.builder()
                .id(3L)
                .componentName("name")
                .build();

        List<ReviewComponent> reviewComponents = List.of(reviewComponent1, reviewComponent2, reviewComponent3);

        when(reviewComponentRepository.findAll()).thenReturn(reviewComponents);

        List<ReviewComponentResponse> result = userReviewService.listReviewComponent();

        verify(reviewComponentRepository).findAll();
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0)).isEqualTo(ReviewComponentMapper.entityToResponse(reviewComponent1));
        assertThat(result.get(1)).isEqualTo(ReviewComponentMapper.entityToResponse(reviewComponent2));
        assertThat(result.get(2)).isEqualTo(ReviewComponentMapper.entityToResponse(reviewComponent3));
    }
}
