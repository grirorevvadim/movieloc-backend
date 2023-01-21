package com.movieloc.movielocapp.controller;

import com.movieloc.movielocapp.dto.MovieDTO;
import com.movieloc.movielocapp.model.MovieModel;
import com.movieloc.movielocapp.service.MovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping(path = "/{id}")
    public MovieModel getMovie(@PathVariable String id) {
        MovieDTO movieDTO = movieService.getMovieById(id);
        MovieModel result = new MovieModel();
        BeanUtils.copyProperties(movieDTO,result);
        return result;
    }

    @PostMapping
    public MovieModel createMovie(@RequestBody MovieModel movie) {
        MovieDTO movieDTO = new MovieDTO();
        MovieModel result = new MovieModel();
        MovieDTO createdMovie;
        BeanUtils.copyProperties(movie, movieDTO);
        createdMovie = movieService.createMovie(movieDTO);
        BeanUtils.copyProperties(createdMovie, result);
        return result;
    }

    @PutMapping
    public String updateMovie() {
        return "update";
    }

    @DeleteMapping
    public String deleteMovie() {
        return "delete";
    }

}
