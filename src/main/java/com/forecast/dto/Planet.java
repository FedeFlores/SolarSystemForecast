package com.forecast.dto;

import java.awt.geom.Point2D;

public class Planet {

	private Integer velocityDegreesPerDay;
	private Integer distanceToTheSunKm;
	private Point2D coordenates;

	/**
	 * @param velocityDegreesPerDay
	 * @param distanceToTheSunKm
	 * @param coordenates
	 */
	public Planet(Integer velocityDegreesPerDay, Integer distanceToTheSunKm, Point2D coordenates) {
		this.velocityDegreesPerDay = velocityDegreesPerDay;
		this.distanceToTheSunKm = distanceToTheSunKm;
		this.coordenates = coordenates;
	}

	/**
	 * @return the velocityDegreesPerDay
	 */
	public Integer getVelocityDegreesPerDay() {
		return velocityDegreesPerDay;
	}

	/**
	 * @param velocityDegreesPerDay the velocityDegreesPerDay to set
	 */
	public void setVelocityDegreesPerDay(Integer velocityDegreesPerDay) {
		this.velocityDegreesPerDay = velocityDegreesPerDay;
	}

	/**
	 * @return the distanceToTheSunKm
	 */
	public Integer getDistanceToTheSunKm() {
		return distanceToTheSunKm;
	}

	/**
	 * @param distanceToTheSunKm the distanceToTheSunKm to set
	 */
	public void setDistanceToTheSunKm(Integer distanceToTheSunKm) {
		this.distanceToTheSunKm = distanceToTheSunKm;
	}

	/**
	 * @return the coordenates
	 */
	public Point2D getCoordenates() {
		return coordenates;
	}

	/**
	 * @param coordenates the coordenates to set
	 */
	public void setCoordenates(Point2D coordenates) {
		this.coordenates = coordenates;
	}

}
