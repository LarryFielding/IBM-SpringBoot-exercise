package com.microservice.training.countriesdemo.controller;

import com.microservice.training.countriesdemo.model.entity.CountryDocument;
import com.microservice.training.countriesdemo.service.api.ICountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CountriesController {

  @Autowired
  ICountriesService countriesService;

  /**
   * Devuelve todos los paises de un continente.
   * @param continentName Nombre del continente.
   * @return Lista de países, lista vacía si no existe el continente.
   */
  @GetMapping(path = "/api/countries/continent/name/{continentName}")
  public ResponseEntity<List<Optional<CountryDocument>>> findCountryByContinent(@PathVariable String continentName) {
    return new ResponseEntity<List<Optional<CountryDocument>>>(
        countriesService.findCountriesByContinentName(continentName.toUpperCase()), HttpStatus.OK);
  }
  
  /**
   * Devuelve un país con el id solicitado.
   * @param countryId
   * @return País solicitado, null si no encuentra el país.
   */
  @GetMapping(path = "/api/countries/country")
  public ResponseEntity<Optional<CountryDocument>> findCountryById(@RequestParam String countryId) {
	  return new ResponseEntity<Optional<CountryDocument>>(
		        countriesService.findCountriesById(countryId), HttpStatus.OK);
  }
  
  /**
   * Inserta un nuevo país.
   * @param country Datos del nuevo país.
   * @return Id del país insertado y estatus Http.
   */
  @PostMapping(path="/api/countries/country")
  public ResponseEntity<String> createCountry(@RequestBody CountryDocument country) {
	  return new ResponseEntity<String>(countriesService.createCountry(country), HttpStatus.OK);
  }

}
