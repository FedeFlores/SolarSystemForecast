package com.forecast.dto;

public class SolarSystem {

	private Planet planet1;
	private Planet planet2;
	private Planet planet3;
	private Double maxPerimeter = Double.valueOf(0);
	private Integer mostRainyDay;
	private Integer actualDay;

	/**
	 * @param planet1
	 * @param planet2
	 * @param planet3
	 */
	public SolarSystem(Planet planet1, Planet planet2, Planet planet3) {
		this.planet1 = planet1;
		this.planet2 = planet2;
		this.planet3 = planet3;
	}

	/**
	 * @return the planet1
	 */
	public Planet getPlanet1() {
		return planet1;
	}

	/**
	 * @param planet1 the planet1 to set
	 */
	public void setPlanet1(Planet planet1) {
		this.planet1 = planet1;
	}

	/**
	 * @return the planet2
	 */
	public Planet getPlanet2() {
		return planet2;
	}

	/**
	 * @param planet2 the planet2 to set
	 */
	public void setPlanet2(Planet planet2) {
		this.planet2 = planet2;
	}

	/**
	 * @return the planet3
	 */
	public Planet getPlanet3() {
		return planet3;
	}

	/**
	 * @param planet3 the planet3 to set
	 */
	public void setPlanet3(Planet planet3) {
		this.planet3 = planet3;
	}

	/**
	 * @return the maxPerimeter
	 */
	public Double getMaxPerimeter() {
		return maxPerimeter;
	}

	/**
	 * @param maxPerimeter the maxPerimeter to set
	 */
	public void setMaxPerimeter(Double maxPerimeter) {
		this.maxPerimeter = maxPerimeter;
	}

	/**
	 * @return the mostRainyDay
	 */
	public Integer getMostRainyDay() {
		return mostRainyDay;
	}

	/**
	 * @param mostRainyDay the mostRainyDay to set
	 */
	public void setMostRainyDay(Integer mostRainyDay) {
		this.mostRainyDay = mostRainyDay;
	}

	/**
	 * @return the actualDay
	 */
	public Integer getActualDay() {
		return actualDay;
	}

	/**
	 * @param actualDay the actualDay to set
	 */
	public void setActualDay(Integer actualDay) {
		this.actualDay = actualDay;
	}

}
