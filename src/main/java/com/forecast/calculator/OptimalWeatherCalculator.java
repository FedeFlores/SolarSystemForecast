package com.forecast.calculator;

import java.awt.geom.Point2D;

import com.forecast.dto.SolarSystem;
import com.forecast.entity.Weather;

public class OptimalWeatherCalculator extends WeatherCalculator {

	@Override
	public Weather calculate(SolarSystem ss) {
		if (planetsAreAligned(ss.getPlanet1().getCoordenates(), ss.getPlanet2().getCoordenates(),
				ss.getPlanet3().getCoordenates())) {
			return Weather.OPTIMAL;
		}
		return nextIfNotNull(ss);
	}

	/** Given 3 points xy, checks if they are aligned between them
	 * @param p1
	 * @param p2
	 * @param p3
	 * @return
	 */
	private Boolean planetsAreAligned(Point2D p1, Point2D p2, Point2D p3) {
		if ((p1.getX() == p2.getX() && p2.getX() == p3.getX()) || p1.getY() == p2.getY() && p2.getY() == p3.getY()) {
			return true;
		}
		Double slope1 = calculateSlope(p1, p2);
		Double slope2 = calculateSlope(p2, p3);
		Double slope3 = calculateSlope(p3, p1);
		return slope1.equals(slope2) && slope2.equals(slope3);
	}

	/** Given 2 points xy, calculates the slope
	 * @param p1
	 * @param p2
	 * @return
	 */
	private Double calculateSlope(Point2D p1, Point2D p2) {
		return (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
	}

}
