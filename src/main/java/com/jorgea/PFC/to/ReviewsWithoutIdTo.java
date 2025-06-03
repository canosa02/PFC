package com.jorgea.PFC.to;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReviewsWithoutIdTo {
    private String reviewText;

    private BigDecimal rating;

    private LocalDateTime reviewDate;

    public ReviewsWithoutIdTo() {
    }

    public ReviewsWithoutIdTo(String reviewText, BigDecimal rating, LocalDateTime reviewDate) {
        this.reviewText = reviewText;
        this.rating = rating;
        this.reviewDate = reviewDate;
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
