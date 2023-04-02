package com.movieloc.movielocapp.model;

import lombok.Data;

@Data
public class LocationModel {
    private long id;
    private String country;
    private String description;
    private String city;
}
