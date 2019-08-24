package com.microservice.training.countriesdemo.service;

import com.microservice.training.countriesdemo.model.entity.CountryDocument;
import com.microservice.training.countriesdemo.repository.api.CountriesMongoRepository;
import com.microservice.training.countriesdemo.service.api.ICountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountriesService implements ICountriesService {
	@Autowired
	CountriesMongoRepository countriesRepository;

	@Override
	public List<Optional<CountryDocument>> findCountriesByContinentName(String continentName) {
		return countriesRepository.findAllByContinent(continentName);
	}

	@Override
	public Optional<CountryDocument> findCountriesById(String countryId) {
		return countriesRepository.findById(countryId);
	}

	@Override
	public String createCountry(CountryDocument country) {
		return countriesRepository.save(country).getId();
	}
  
  

}
