package com.forecast;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.forecast.entity.Day;
import com.forecast.service.ForecastService;

@SpringBootApplication
public class ForecastApplication implements ApplicationRunner {

	@Autowired
	private ForecastService forecastService;

	public static void main(String[] args) {
		SpringApplication.run(ForecastApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Day> days = forecastService.calculateWeatherTenYears();
		forecastService.saveDaysList(days);
	}

}
