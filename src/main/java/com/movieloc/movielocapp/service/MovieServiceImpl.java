package com.movieloc.movielocapp.service;

import com.movieloc.movielocapp.dto.MovieDTO;
import com.movieloc.movielocapp.entity.MovieEntity;
import com.movieloc.movielocapp.repository.MovieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieDTO createMovie(MovieDTO movieDTO) {
        MovieEntity movieEntity = new MovieEntity();
        BeanUtils.copyProperties(movieDTO, movieEntity);
        var createdMovie = movieRepository.save(movieEntity);
        BeanUtils.copyProperties(createdMovie, movieDTO);
        return movieDTO;
    }
}
