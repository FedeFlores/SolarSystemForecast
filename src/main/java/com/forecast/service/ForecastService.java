package com.forecast.service;

import java.util.List;

import com.forecast.dto.ExtendedForecast;
import com.forecast.entity.Day;

public interface ForecastService {

	/**
	 * Calculates weather conditions for the next years
	 * 
	 * @return
	 */
	List<Day> calculateWeatherTenYears();

	/**
	 * Saves days list on DB
	 * 
	 * @param days
	 */
	void saveDaysList(List<Day> days);

	/**
	 * Search day by id
	 * 
	 * @param day
	 * @return
	 */
	Day findDayById(Integer day);

	/**
	 * Calculates critical weather data in the next ten years
	 * 
	 * @return
	 */
	ExtendedForecast getExtendedForecast();

}
