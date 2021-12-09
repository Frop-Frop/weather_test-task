package com.ridersoft.weatherapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ridersoft.weatherapp.services.WeatherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Order controller", description = "Order related operations")
@RestController
@RequestMapping("weather")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@Operation(summary = "Get today's weather")
	@GetMapping()
	public ResponseEntity<Integer> getTodaysWeather() {
		return new ResponseEntity<Integer>(weatherService.getTodaysTemperature(), HttpStatus.OK);
	}

}
