package com.microservice.training.countriesdemo.service.api;

import com.microservice.training.countriesdemo.model.entity.CountryDocument;

import java.util.List;
import java.util.Optional;

public interface ICountriesService {

  List<Optional<CountryDocument>> findCountriesByContinentName(String continentName);
  
  CountryDocument findCountriesById(Integer countryId);
  
  Integer createCountry(CountryDocument country);
  
}
