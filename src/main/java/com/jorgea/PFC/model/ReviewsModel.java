package com.jorgea.PFC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
public class ReviewsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;

    // todo: meter users

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private GamesModel game;

    private String reviewText;

    private BigDecimal rating;

    private LocalDateTime reviewDate;

    public ReviewsModel() {
    }

    public ReviewsModel(Integer reviewId, GamesModel game, String reviewText, BigDecimal rating, LocalDateTime reviewDate) {
        this.reviewId = reviewId;
        this.game = game;
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

    public GamesModel getGame() {
        return game;
    }

    public void setGame(GamesModel game) {
        this.game = game;
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
