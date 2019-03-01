package com.forecast.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.forecast.dto.ExtendedForecast;
import com.forecast.entity.Day;
import com.forecast.entity.Weather;
import com.forecast.exception.DayNotFoundException;
import com.forecast.exception.InvalidDayException;
import com.forecast.repository.DayRepository;
import com.forecast.service.ForecastServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ForecastServiceTest {

	@Mock
	private DayRepository dayRepo;

	@InjectMocks
	private ForecastServiceImpl forecastService;

	@Test
	public void calculateWeatherTenYearsTest() {
		List<Day> days = forecastService.calculateWeatherTenYears();
		assertEquals(3650, days.size());
		assertEquals(1, days.stream().filter(d -> d.getWeather().equals(Weather.THUNDERSTORM)).count());
		assertEquals(Weather.DRY, days.get(0).getWeather());
	}

	@Test
	public void saveDaysListTest() {
		List<Day> days = new ArrayList<>();
		forecastService.saveDaysList(days);
		Mockito.verify(dayRepo, Mockito.times(1)).saveAll(days);
	}

	@Test
	public void findDayByIdTest() {
		Mockito.when(dayRepo.findById("1")).thenReturn(Optional.of(new Day("1", Weather.DRY)));
		Day day = forecastService.findDayById(1);
		assertEquals("1", day.getId());
		assertEquals(Weather.DRY, day.getWeather());
	}

	@Test(expected = DayNotFoundException.class)
	public void findDayByIdDayNotFoundExceptionTest() {
		forecastService.findDayById(1);
	}
	
	@Test(expected = InvalidDayException.class)
	public void findDayByIdInvalidDayExceptionTest() {
		forecastService.findDayById(0);
	}


	@Test
	public void getExtendedForecastTest() {
		Day day1 = new Day("1", Weather.DRY);
		Day day2 = new Day("2", Weather.RAIN);
		Day day3 = new Day("3", Weather.THUNDERSTORM);
		Day day4 = new Day("4", Weather.OPTIMAL);
		List<Day> days = new ArrayList<Day>(Arrays.asList(day1, day2, day3, day4));
		Mockito.when(dayRepo.findAll()).thenReturn(days);
		ExtendedForecast extForecast = forecastService.getExtendedForecast();
		assertEquals(Long.valueOf(1), extForecast.getDryDays());
		assertEquals(Long.valueOf(1), extForecast.getRainDays());
		assertEquals(Long.valueOf(1), extForecast.getOptimalDays());
		assertEquals("3", extForecast.getMaxRainDay());
	}

	@Test(expected = DayNotFoundException.class)
	public void getExtendedForecastExceptionest() {
		Day day1 = new Day("1", Weather.DRY);
		Day day2 = new Day("2", Weather.RAIN);
		Day day3 = new Day("3", Weather.RAIN);
		Day day4 = new Day("4", Weather.OPTIMAL);
		List<Day> days = new ArrayList<Day>(Arrays.asList(day1, day2, day3, day4));
		Mockito.when(dayRepo.findAll()).thenReturn(days);
		forecastService.getExtendedForecast();
	}

}
