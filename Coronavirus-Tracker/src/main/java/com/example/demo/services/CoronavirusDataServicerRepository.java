package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.LocationStates;

public interface CoronavirusDataServicerRepository extends JpaRepository<LocationStates, Long> {

	

	 List<LocationStates> findByLatestTotalDeaths(int count);
	  List<LocationStates> findAllByOrderByLatestTotalDeathsDesc();
	  
	  List<LocationStates> findByCountryIgnoreCase(String country);
	  Optional<LocationStates> findById(Long id);
	  
	  List<LocationStates> findAll();
	  
	  
}
