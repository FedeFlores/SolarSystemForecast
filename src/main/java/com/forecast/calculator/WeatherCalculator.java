package com.forecast.calculator;

import com.forecast.dto.SolarSystem;
import com.forecast.entity.Weather;

public abstract class WeatherCalculator {

	protected WeatherCalculator nextCalculator;

	/**
	 * Sets the next WeatherCalculator in the chain
	 * 
	 * @param weatherCalculator
	 */
	public void setNextCalculator(WeatherCalculator weatherCalculator) {
		this.nextCalculator = weatherCalculator;
	}

	/**
	 * Calls the calculate method on the next WeatherCalculator of the chain. If no
	 * WeatherCalculator was set, return unknown weather
	 * 
	 * @param ss
	 * @return
	 */
	protected Weather nextIfNotNull(SolarSystem ss) {
		return nextCalculator != null ? nextCalculator.calculate(ss) : Weather.UNKNOWN;
	}

	/**
	 * Calculates Weather for a given day in the SolarSystem based on planets
	 * position
	 * 
	 * @param ss
	 * @return
	 */
	public abstract Weather calculate(SolarSystem ss);

}
