package com.jorgea.PFC.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReviewsDto {
    private Integer reviewId;

    private String reviewText;

    private BigDecimal rating;

    private LocalDateTime reviewDate;

    public ReviewsDto() {
    }

    public ReviewsDto(Integer reviewId, String reviewText, BigDecimal rating, LocalDateTime reviewDate) {
        this.reviewId = reviewId;
        this.reviewText = reviewText;
        this.rating = rating;
        this.reviewDate = reviewDate;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }
}
