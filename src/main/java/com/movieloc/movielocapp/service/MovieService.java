package com.movieloc.movielocapp.service;

import com.movieloc.movielocapp.dto.MovieDTO;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {
     MovieDTO createMovie(MovieDTO movieDTO);

     MovieDTO getMovieById(String id);
}
