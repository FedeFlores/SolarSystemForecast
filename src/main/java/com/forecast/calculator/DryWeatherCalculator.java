package com.forecast.calculator;

import java.awt.geom.Point2D;

import com.forecast.dto.SolarSystem;
import com.forecast.entity.Weather;

public class DryWeatherCalculator extends WeatherCalculator {

	@Override
	public Weather calculate(SolarSystem ss) {
		if (planetsAreAlignedWithSun(ss.getPlanet1().getCoordenates(), ss.getPlanet2().getCoordenates(),
				ss.getPlanet3().getCoordenates())) {
			return Weather.DRY;
		}
		return nextIfNotNull(ss);
	}

	/**
	 * Given 3 points xy, checks if they are aligned with Sun point (x=0 y=0)
	 * @param p1
	 * @param p2
	 * @param p3
	 * @return
	 */
	private Boolean planetsAreAlignedWithSun(Point2D p1, Point2D p2, Point2D p3) {
		return (p1.getX() == 0 && p2.getX() == 0 && p3.getX() == 0)
				|| (p1.getY() == 0 && p2.getY() == 0 && p3.getY() == 0);
	}

}
