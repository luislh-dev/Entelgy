package com.entelgy.config;

import com.entelgy.factory.AnimalFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.entelgy")
public class Configuracion {
	@Bean
	public AnimalFactory animalFactory() {
		return new AnimalFactory();
	}
}
