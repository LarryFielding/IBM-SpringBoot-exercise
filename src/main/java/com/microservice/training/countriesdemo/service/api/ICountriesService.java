package com.microservice.training.countriesdemo.service.api;

import com.microservice.training.countriesdemo.model.entity.CountryEntity;

import java.util.List;

public interface ICountriesService {
	
	List<CountryEntity> findCountriesByContinentName(String continentName);
		
	Integer createCountry(CountryEntity country);

	CountryEntity findCountriesById(Integer countryId);
  
}
