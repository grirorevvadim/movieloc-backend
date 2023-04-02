package com.movieloc.movielocapp.service;

import com.movieloc.movielocapp.dto.LocationDTO;
import com.movieloc.movielocapp.dto.MovieDTO;
import com.movieloc.movielocapp.entity.LocationEntity;
import com.movieloc.movielocapp.entity.MovieEntity;
import com.movieloc.movielocapp.repository.LocationRepository;
import com.movieloc.movielocapp.repository.MovieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;

//    public MovieDTO createMovie(MovieDTO movieDTO) {
//        if (movieRepository.findByMovieName(movieDTO.getMovieName()) != null)
//            throw new RuntimeException("Movie already exists");
//
//        MovieEntity movieEntity = new MovieEntity();
//        BeanUtils.copyProperties(movieDTO, movieEntity);
//        long leftLimit = 1L;
//        long rightLimit = 1000000L;
//        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
//        movieEntity.setId(generatedLong);
//        var createdMovie = movieRepository.save(movieEntity);
//        BeanUtils.copyProperties(createdMovie, movieDTO);
//        return movieDTO;
//    }
//

    @Override
    public LocationDTO createLocation(LocationDTO locationDTO) {
        if(locationRepository.findByCity(locationDTO.getCity())!=null) throw new RuntimeException("Location already exists");

        LocationEntity location = new LocationEntity();
        BeanUtils.copyProperties(locationDTO,location);
        long leftLimit = 1L;
        long rightLimit = 1000000L;
        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        location.setId(generatedLong);
        var createLoc = locationRepository.save(location);
        BeanUtils.copyProperties(createLoc,locationDTO);
        return locationDTO;
    }

    @Override
    public LocationDTO getLocationById(String id) {
        var loc = locationRepository.findById(Long.parseLong(id));
        LocationDTO locationDTO = new LocationDTO();
        if(loc.isEmpty())throw new RuntimeException("Location with id:" + id + " was not found");
        BeanUtils.copyProperties(loc.get(), locationDTO);
        return locationDTO;
    }

    @Override
    public List<LocationDTO> getAll() {
        var movies = locationRepository.findAll();
        List<LocationDTO> locationDTOS = new ArrayList<>();

        for (LocationEntity movie : locationRepository.findAll()) {
            LocationDTO m = new LocationDTO();
            BeanUtils.copyProperties(movie, m);
            locationDTOS.add(m);
        }
        return locationDTOS;
    }
}
