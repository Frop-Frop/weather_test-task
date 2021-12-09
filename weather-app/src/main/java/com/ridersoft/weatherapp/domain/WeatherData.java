package com.ridersoft.weatherapp.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "weather_history")
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {

	@Id
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date weatherDate;
	private int weatherValue;

}
