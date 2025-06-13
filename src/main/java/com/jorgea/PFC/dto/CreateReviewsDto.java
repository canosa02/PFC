package com.jorgea.PFC.dto;

import com.jorgea.PFC.validation.StringNotBlank;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;

public class CreateReviewsDto {
    private Integer userId;

    @StringNotBlank
    private String reviewText;

    @DecimalMin(value = "0.0", message = "Rating must be at least 0")
    @DecimalMax(value = "10.0", message = "Rating must not exceed 10")
    private BigDecimal rating;

    public CreateReviewsDto() {
    }

    public CreateReviewsDto(Integer userId, String reviewText, BigDecimal rating) {
        this.userId = userId;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
