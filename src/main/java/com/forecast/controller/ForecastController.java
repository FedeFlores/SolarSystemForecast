package com.forecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.forecast.dto.ExtendedForecast;
import com.forecast.entity.Day;
import com.forecast.service.ForecastService;

@RestController
public class ForecastController {

	@Autowired
	private ForecastService forecastService;

	@GetMapping(value = "/weather/{day}")
	public Day findDayById(@PathVariable("day") Integer day) {
		return forecastService.findDayById(day);
	}

	@GetMapping(value = "/extendedForecast")
	public ExtendedForecast extendedForecast() {
		return forecastService.getExtendedForecast();
	}

}
