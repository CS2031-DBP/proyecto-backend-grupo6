package org.grupo6.main.review.domain;

import org.grupo6.main.exceptions.ReviewNotFoundException;
import org.grupo6.main.review.dto.ReviewDto;
import org.grupo6.main.review.infrastructure.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<ReviewDto> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public ReviewDto createReview(ReviewDto reviewDto) {
        Review review = new Review();
        review.setUser(reviewDto.getUser());
        review.setRestaurant(reviewDto.getRestaurant());
        review.setValoracion(reviewDto.getValoracion());
        review.setComentario(reviewDto.getComentario());
        reviewRepository.save(review);
        return convertToDto(review);
    }

    public ReviewDto getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("Review no encontrada"));
        return convertToDto(review);
    }

    public ReviewDto updateReview(Long id, ReviewDto reviewDto) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("Review no encontrada"));
        review.setUser(reviewDto.getUser());
        review.setRestaurant(reviewDto.getRestaurant());
        review.setValoracion(reviewDto.getValoracion());
        review.setComentario(reviewDto.getComentario());
        reviewRepository.save(review);
        return convertToDto(review);
    }

    public void deleteReview(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("Review no encontrada"));
        reviewRepository.delete(review);
    }

    private ReviewDto convertToDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setUser(review.getUser());
        reviewDto.setRestaurant(review.getRestaurant());
        reviewDto.setValoracion(review.getValoracion());
        reviewDto.setComentario(review.getComentario());
        return reviewDto;
    }

}
