package com.forecast.calculator;

import java.awt.geom.Point2D;

import com.forecast.dto.SolarSystem;
import com.forecast.entity.Weather;

public class RainWeatherCalculator extends WeatherCalculator {

	@Override
	public Weather calculate(SolarSystem ss) {
		if (sunInsideTriangle(ss)) {
			Double perimeter = calculatePerimeter(ss.getPlanet1().getCoordenates(), ss.getPlanet2().getCoordenates(),
					ss.getPlanet3().getCoordenates());
			if (perimeter > ss.getMaxPerimeter()) {
				ss.setMaxPerimeter(perimeter);
				ss.setMostRainyDay(ss.getActualDay());
			}
			return Weather.RAIN;
		}
		return nextIfNotNull(ss);
	}

	/** Checks if sun is inside the triangle formed by the 3 planets of the solar system
	 * @param ss
	 * @return
	 */
	private Boolean sunInsideTriangle(SolarSystem ss) {
		Point2D p1 = ss.getPlanet1().getCoordenates();
		Point2D p2 = ss.getPlanet2().getCoordenates();
		Point2D p3 = ss.getPlanet3().getCoordenates();
		Point2D sun = new Point2D.Double(0, 0);
		Double orientation1 = calculateTriangleOrientation(p1, p2, p3);
		Double orientation2 = calculateTriangleOrientation(p1, p2, sun);
		Double orientation3 = calculateTriangleOrientation(p2, p3, sun);
		Double orientation4 = calculateTriangleOrientation(p3, p1, sun);
		return (orientation1 > 0 && orientation2 > 0 && orientation3 > 0 && orientation4 > 0)
				|| (orientation1 < 0 && orientation2 < 0 && orientation3 < 0 && orientation4 < 0);
	}

	/** Given 3 points xy, calculates the triangle orientation
	 * @param p1
	 * @param p2
	 * @param p3
	 * @return
	 */
	private Double calculateTriangleOrientation(Point2D p1, Point2D p2, Point2D p3) {
		return (p1.getX() - p3.getX()) * (p2.getY() - p3.getY()) - (p1.getY() - p3.getY()) * (p2.getX() - p3.getX());
	}

	/** Given 3 points xy, calculates the perimeter
	 * @param p1
	 * @param p2
	 * @param p3
	 * @return
	 */
	private Double calculatePerimeter(Point2D p1, Point2D p2, Point2D p3) {
		return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
	}

}
