package com.movieloc.movielocapp.model;

import lombok.Data;

@Data
public class MovieModel {
    private long id;
    private String movieName;
    private String description;
    private String location;
}
