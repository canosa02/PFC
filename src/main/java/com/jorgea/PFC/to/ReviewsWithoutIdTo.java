package com.jorgea.PFC.to;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReviewsWithoutIdTo {
    private String userName;

    private String reviewText;

    private BigDecimal rating;

    private LocalDate reviewDate;

    public ReviewsWithoutIdTo() {
    }

    public ReviewsWithoutIdTo(String userName, String reviewText, BigDecimal rating, LocalDate reviewDate) {
        this.userName = userName;
        this.reviewText = reviewText;
        this.rating = rating;
        this.reviewDate = reviewDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }
}
