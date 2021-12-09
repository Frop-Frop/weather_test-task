package com.ridersoft.weatherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(info = @Info(title = "Weather API", version = "1.0", description = "Made as test task for Rider Soft", termsOfService = "https://www.apache.org/licenses/LICENSE-2.0", contact = @Contact(name = "Sofia Kim", email = "sophianpilova@gmail.com"), license = @License(name = "Apache license Version 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0")))
@SpringBootApplication
public class WeatherAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherAppApplication.class, args);
	}

}
