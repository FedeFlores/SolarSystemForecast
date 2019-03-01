package com.forecast.entity;

public enum Weather {

	/**	DRY: Planets aligned with the Sun
	 *  RAIN: Planets position forming a triangle with the Sun inside it
	 *  THUNDERSTORM: Planets position forming a triangle with the Sun inside it AND max perimiter triangle
	 *  OPTIMAL: Planets aligned between them but not with the Sun
	 *  UNKNOWN: Planets position forming a triangle WITHOUT the Sun inside it. No weather condition was given for this scenario
	 */
	DRY, RAIN, THUNDERSTORM, OPTIMAL, UNKNOWN;

}
