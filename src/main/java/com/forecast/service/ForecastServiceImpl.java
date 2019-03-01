package com.forecast.service;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forecast.calculator.DryWeatherCalculator;
import com.forecast.calculator.OptimalWeatherCalculator;
import com.forecast.calculator.RainWeatherCalculator;
import com.forecast.calculator.WeatherCalculator;
import com.forecast.dto.ExtendedForecast;
import com.forecast.dto.Planet;
import com.forecast.dto.PlanetBuilder;
import com.forecast.dto.SolarSystem;
import com.forecast.entity.Day;
import com.forecast.entity.Weather;
import com.forecast.exception.DayNotFoundException;
import com.forecast.exception.InvalidDayException;
import com.forecast.repository.DayRepository;

@Service
public class ForecastServiceImpl implements ForecastService {

	@Autowired
	private DayRepository dayRepo;

	private static final Integer YEAR_IN_DAYS = 3650;
	private static final Integer ROUND_DECIMAL_QTY = 1;

	@Override
	public List<Day> calculateWeatherTenYears() {
		SolarSystem ss = new SolarSystem(PlanetBuilder.initFerengi(), PlanetBuilder.initBetasoide(),
				PlanetBuilder.initVulcano());
		Map<Integer, Day> days = new HashMap<>(YEAR_IN_DAYS);
		for (int i = 1; i <= YEAR_IN_DAYS; i++) {
			ss.setActualDay(i);
			WeatherCalculator weatherCalc = configWeatherCalculator();
			days.put(i, new Day(String.valueOf(i), weatherCalc.calculate(ss)));
			movePlanets(ss);
		}
		days.get(ss.getMostRainyDay()).setWeather(Weather.THUNDERSTORM);
		return new ArrayList<>(days.values());
	}

	/**
	 * Configures the chain of responsibility
	 * 
	 * @return
	 */
	private WeatherCalculator configWeatherCalculator() {
		WeatherCalculator dryCalc = new DryWeatherCalculator();
		WeatherCalculator optimalCalc = new OptimalWeatherCalculator();
		WeatherCalculator rainCalc = new RainWeatherCalculator();
		dryCalc.setNextCalculator(optimalCalc);
		optimalCalc.setNextCalculator(rainCalc);
		return dryCalc;
	}

	/**
	 * Moves the planet 1 day
	 * 
	 * @param ss
	 */
	private void movePlanets(SolarSystem ss) {
		ss.getPlanet1().setCoordenates(obtainNewCoordenates(ss.getPlanet1(), ss.getActualDay()));
		ss.getPlanet2().setCoordenates(obtainNewCoordenates(ss.getPlanet2(), ss.getActualDay()));
		ss.getPlanet3().setCoordenates(obtainNewCoordenates(ss.getPlanet3(), ss.getActualDay()));
	}

	/**
	 * Gets x and y points for the next day
	 * 
	 * @param planet
	 * @param day
	 * @return
	 */
	private Point2D obtainNewCoordenates(Planet planet, Integer day) {
		Double dDay = Double.valueOf(day);
		Double x = planet.getDistanceToTheSunKm() * Math.cos(Math.toRadians(planet.getVelocityDegreesPerDay() * dDay));
		Double y = planet.getDistanceToTheSunKm() * Math.sin(Math.toRadians(planet.getVelocityDegreesPerDay() * dDay));
		return new Point2D.Double(Precision.round(x, ROUND_DECIMAL_QTY), Precision.round(y, ROUND_DECIMAL_QTY));
	}

	@Override
	public void saveDaysList(List<Day> days) {
		dayRepo.saveAll(days);
	}

	@Override
	public Day findDayById(Integer day) {
		if (day < 1 || day > 3650) {
			throw new InvalidDayException();
		}
		Optional<Day> optDay = dayRepo.findById(String.valueOf(day));
		if (optDay.isPresent()) {
			return optDay.get();
		} else {
			throw new DayNotFoundException();
		}
	}

	@Override
	public ExtendedForecast getExtendedForecast() {
		ExtendedForecast extendedForecast = new ExtendedForecast();
		List<Day> days = new ArrayList<>();
		dayRepo.findAll().forEach(days::add);
		extendedForecast.setDryDays(days.stream().filter(d -> Weather.DRY.equals(d.getWeather())).count());
		extendedForecast.setRainDays(days.stream().filter(d -> Weather.RAIN.equals(d.getWeather())).count());
		Optional<Day> optMaxRainDay = days.stream().filter(d -> Weather.THUNDERSTORM.equals(d.getWeather()))
				.findFirst();
		if (optMaxRainDay.isPresent()) {
			extendedForecast.setMaxRainDay(optMaxRainDay.get().getId());
		} else {
			throw new DayNotFoundException();
		}
		extendedForecast.setOptimalDays(days.stream().filter(d -> Weather.OPTIMAL.equals(d.getWeather())).count());
		return extendedForecast;
	}

}
