package com.jorgea.PFC.model;

import jakarta.persistence.*;

@Entity
@Table(name = "series")
public class SerieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmId;

    private String title;
    private String description;
    private String director;
    private String releaseDate;
    private double rating;
}
