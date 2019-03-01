package com.forecast.dto;

import java.awt.Point;

public class PlanetBuilder {

	/**
	 * @return planet Ferengi with its initial values (day 0)
	 */
	public static Planet initFerengi() {
		return new Planet(1, 500, new Point(0, 500));
	}

	/**
	 * @return planet Betasoide with its initial values (day 0)
	 */
	public static Planet initBetasoide() {
		return new Planet(3, 2000, new Point(0, 2000));
	}

	/**
	 * @return planet Vulcano with its initial values (day 0)
	 */
	public static Planet initVulcano() {
		return new Planet(-5, 1000, new Point(0, 1000));
	}

}
