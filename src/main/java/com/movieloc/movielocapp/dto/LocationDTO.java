package com.movieloc.movielocapp.dto;

import lombok.Data;

@Data
public class LocationDTO {
    private long id;
    private String city;
    private String country;
    private String description;
}
