package com.forecast.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Day {

	@Id
	private String id;
	private Weather weather;

	/**
	 * @param id
	 * @param weather
	 */
	public Day(String id, Weather weather) {
		this.id = id;
		this.weather = weather;
	}

	/**
	 * 
	 */
	public Day() {
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the weather
	 */
	public Weather getWeather() {
		return weather;
	}

	/**
	 * @param weather the weather to set
	 */
	public void setWeather(Weather weather) {
		this.weather = weather;
	}

}
