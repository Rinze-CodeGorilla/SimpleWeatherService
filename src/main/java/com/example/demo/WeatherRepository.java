package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeatherRepository extends CrudRepository<Weather, Long> {
    List<Weather> findAllBy();
    Weather findFirstByCityOrderByTemperatureDesc(String city);
}
