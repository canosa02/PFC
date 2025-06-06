package com.jorgea.PFC.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class UsersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ReviewsModel> reviewsModels;

    public UsersModel() {
    }

    public UsersModel(Integer userId, String username, String password, List<ReviewsModel> reviewsModels) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.reviewsModels = reviewsModels;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ReviewsModel> getReviewsModels() {
        return reviewsModels;
    }

    public void setReviewsModels(List<ReviewsModel> reviewsModels) {
        this.reviewsModels = reviewsModels;
    }
}
