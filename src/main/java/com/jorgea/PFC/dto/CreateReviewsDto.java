package com.jorgea.PFC.dto;

import com.jorgea.PFC.validation.StringNotBlank;

import java.math.BigDecimal;

public class CreateReviewsDto {
    @StringNotBlank
    private String reviewText;

    private BigDecimal rating;

    public CreateReviewsDto() {
    }

    public CreateReviewsDto(String reviewText, BigDecimal rating) {
        this.reviewText = reviewText;
        this.rating = rating;
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
