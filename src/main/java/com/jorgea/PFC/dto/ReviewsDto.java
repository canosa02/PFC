package com.jorgea.PFC.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ReviewsDto {
    private Integer reviewId;

    private String userName;

    private String reviewText;

    private BigDecimal rating;

    private Date reviewDate;

    public ReviewsDto() {
    }

    public ReviewsDto(Integer reviewId, String userName, String reviewText, BigDecimal rating, Date reviewDate) {
        this.reviewId = reviewId;
        this.userName = userName;
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

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }
}
