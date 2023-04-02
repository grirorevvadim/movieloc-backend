package com.movieloc.movielocapp.controller;

import com.movieloc.movielocapp.dto.MovieDTO;
import com.movieloc.movielocapp.model.MovieModel;
import com.movieloc.movielocapp.service.MovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin("http://localhost:8080/")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping()
    public List<MovieModel> getAllMovies() {
        List<MovieDTO> movies = movieService.getAll();
        List<MovieModel> resultMovies = new ArrayList<>();
        for (MovieDTO m : movies) {
            MovieModel model = new MovieModel();
            BeanUtils.copyProperties(m, model);
            resultMovies.add(model);
        }
        return resultMovies;
    }

    @GetMapping(path = "/{id}")
    public MovieModel getMovie(@PathVariable String id) {
        MovieDTO movieDTO = movieService.getMovieById(id);
        MovieModel result = new MovieModel();
        BeanUtils.copyProperties(movieDTO, result);
        return result;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
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
