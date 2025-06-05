package com.jorgea.PFC.to;

import java.math.BigDecimal;

public class CreateReviewsTo {
    private String reviewText;

    private BigDecimal rating;

    public CreateReviewsTo() {
    }

    public CreateReviewsTo(String reviewText, BigDecimal rating) {
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
