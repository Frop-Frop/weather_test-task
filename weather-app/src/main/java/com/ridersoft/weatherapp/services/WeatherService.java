package com.ridersoft.weatherapp.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ridersoft.weatherapp.domain.WeatherData;
import com.ridersoft.weatherapp.repositories.WeatherRepository;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository weatherRepository;

	private static final Logger log = Logger.getLogger(WeatherService.class.getName());

	public Integer getTodaysTemperature() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = formatter.parse(formatter.format(new Date()));
		} catch (ParseException e1) {
			log.error(e1);
		}
		Optional<WeatherData> weatherToday = weatherRepository.findById(date);
		if (weatherToday.isPresent()) {
			return weatherToday.get().getWeatherValue();
		} else {
			int temperature = 0;

			InputStream is = null;
			try {
				URL url = new URL("https://yandex.ru/");
				URLConnection con = url.openConnection();
				is = con.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String line;

				while ((line = br.readLine()) != null) {
					String keyLine = "</div><div class='weather__temp'>";
					String closingKeyLine = "°</div></a><div class='weather__forecast'>";
					if (line.contains(keyLine)) {
						temperature = Integer.valueOf(
								line.substring(line.indexOf(keyLine) + keyLine.length(), line.indexOf(closingKeyLine)));
					}
				}
				;
			} catch (MalformedURLException e) {
				log.error(e);
			} catch (IOException e) {
				log.error(e);
			}
			weatherRepository.save(new WeatherData(date, temperature));
			return temperature;
		}
	}

}
