package com.deepak.springannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.deepak.springannotation")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// Define bean for sad fortune service
	@Bean
	public FortuneService sadFortuneService(){
		return new SadFortuneService();
	}
	
	// Define bean for our swim coach and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	
}
