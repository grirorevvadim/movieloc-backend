package com.movieloc.movielocapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity(name = "locations")
@Data
public class LocationEntity {
    @Id
    private long id;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String description;
}
