package com.movieloc.movielocapp.controller;

import com.movieloc.movielocapp.dto.LocationDTO;
import com.movieloc.movielocapp.model.LocationModel;
import com.movieloc.movielocapp.service.LocationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/locations")
@CrossOrigin("http://localhost:8080/")
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping()
    public List<LocationModel> getAllLocations() {
        List<LocationDTO> locations = locationService.getAll();
        List<LocationModel> resultLocations = new ArrayList<>();
        for (LocationDTO m : locations) {
            LocationModel model = new LocationModel();
            BeanUtils.copyProperties(m, model);
            resultLocations.add(model);
        }
        return resultLocations;
    }

    @GetMapping(path = "/{id}")
    public LocationModel getLocation(@PathVariable String id) {
        LocationDTO locationDTO = locationService.getLocationById(id);
        LocationModel result = new LocationModel();
        BeanUtils.copyProperties(locationDTO, result);
        return result;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public LocationModel createLocation(@RequestBody LocationModel Location) {
        LocationDTO LocationDTO = new LocationDTO();
        LocationModel result = new LocationModel();
        LocationDTO createdLocation;
        BeanUtils.copyProperties(Location, LocationDTO);
        createdLocation = locationService.createLocation(LocationDTO);
        BeanUtils.copyProperties(createdLocation, result);
        return result;
    }

    @PutMapping
    public String updateLocation() {
        return "update";
    }

    @DeleteMapping
    public String deleteLocation() {
        return "delete";
    }

}
