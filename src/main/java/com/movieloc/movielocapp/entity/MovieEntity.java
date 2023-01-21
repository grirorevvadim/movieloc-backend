package com.movieloc.movielocapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


@Entity(name = "movies")
@Data
public class MovieEntity {
    @Id
    @GeneratedValue
    private long id;

    @Column ()
    private String movieName;

    @Column
    private String description;
    @Column
    private String location;
}
