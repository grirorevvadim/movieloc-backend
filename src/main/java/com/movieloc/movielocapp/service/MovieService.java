package com.movieloc.movielocapp.service;

import com.movieloc.movielocapp.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
     MovieDTO createMovie(MovieDTO movieDTO);

     MovieDTO getMovieById(String id);

     List<MovieDTO> getAll();
}
