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
        if (movieRepository.findByMovieName(movieDTO.getMovieName()) != null)
            throw new RuntimeException("Movie already exists");

        MovieEntity movieEntity = new MovieEntity();
        BeanUtils.copyProperties(movieDTO, movieEntity);
        long leftLimit = 1L;
        long rightLimit = 1000000L;
        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        movieEntity.setId(generatedLong);
        var createdMovie = movieRepository.save(movieEntity);
        BeanUtils.copyProperties(createdMovie, movieDTO);
        return movieDTO;
    }

    @Override
    public MovieDTO getMovieById(String id) {
        var movie = movieRepository.findById(Long.parseLong(id));
        MovieDTO movieDTO = new MovieDTO();
        if (movie.isEmpty()) throw new RuntimeException("Movie with id:" + id + " was not found");
        BeanUtils.copyProperties(movie.get(), movieDTO);
        return movieDTO;
    }
}
