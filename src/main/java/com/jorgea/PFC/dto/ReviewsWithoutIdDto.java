package com.jorgea.PFC.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class ReviewsWithoutIdDto {
    private String reviewText;

    private BigDecimal rating;

    private Date reviewDate;

    public ReviewsWithoutIdDto() {
    }

    public ReviewsWithoutIdDto(String reviewText, BigDecimal rating, Date reviewDate) {
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

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }
}
