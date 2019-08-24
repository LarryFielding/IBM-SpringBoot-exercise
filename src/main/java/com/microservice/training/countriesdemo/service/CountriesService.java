package com.microservice.training.countriesdemo.service;

import com.microservice.training.countriesdemo.model.entity.CountryEntity;
import com.microservice.training.countriesdemo.repository.api.CountryJpaRepository;
import com.microservice.training.countriesdemo.service.api.ICountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountriesService implements ICountriesService {

  @Autowired
  CountryJpaRepository countriesRepository;
  
  @Override
  public List<CountryEntity> findCountriesByContinentName(String continentName) {
	  List<CountryEntity> lista = countriesRepository.findAllByContinent(continentName);
	  return lista;
  }
  
  @Override
  public Integer createCountry(CountryEntity country) {
	  return countriesRepository.save(country).getCountryId();
  }
  
  @Override
  public CountryEntity findCountriesById(Integer countryId) {
	  return countriesRepository.findByCountryId(countryId);  
  }  
}

