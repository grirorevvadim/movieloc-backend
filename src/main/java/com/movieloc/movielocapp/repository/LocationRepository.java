package com.movieloc.movielocapp.repository;

import com.movieloc.movielocapp.entity.LocationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<LocationEntity, Long> {
    LocationEntity findByCity(String city);
}
