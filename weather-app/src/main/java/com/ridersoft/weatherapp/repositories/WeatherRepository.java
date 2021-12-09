package com.ridersoft.weatherapp.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ridersoft.weatherapp.domain.WeatherData;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherData, Date> {

}
