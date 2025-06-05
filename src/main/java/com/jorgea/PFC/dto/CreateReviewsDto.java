package com.jorgea.PFC.dto;

import com.jorgea.PFC.validation.StringNotBlank;

import java.math.BigDecimal;

public class CreateReviewsDto {
    private Integer userId;

    @StringNotBlank
    private String reviewText;

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
