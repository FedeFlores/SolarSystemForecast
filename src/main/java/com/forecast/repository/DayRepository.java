package com.forecast.repository;

import org.springframework.data.repository.CrudRepository;

import com.forecast.entity.Day;

public interface DayRepository extends CrudRepository<Day, String> {

}
