package com.jorgea.PFC.to;

import java.math.BigDecimal;

public class UpdateReviewsTo {
    private String reviewText;
    private BigDecimal rating;

    public UpdateReviewsTo() {
    }

    public UpdateReviewsTo(String reviewText, BigDecimal rating) {
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