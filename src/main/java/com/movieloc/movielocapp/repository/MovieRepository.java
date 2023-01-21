package com.movieloc.movielocapp.repository;

import com.movieloc.movielocapp.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Long> {
    MovieEntity findByMovieName(String movieName);
}
