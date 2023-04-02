package com.movieloc.movielocapp.service;

import com.movieloc.movielocapp.dto.LocationDTO;
import com.movieloc.movielocapp.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {
     LocationDTO createLocation(LocationDTO movieDTO);

     LocationDTO getLocationById(String id);

     List<LocationDTO> getAll();
}
