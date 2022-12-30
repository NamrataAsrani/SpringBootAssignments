package com.rest.demo.healthchecks;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCustom implements HealthIndicator {

	@Override
	public Health health() {
		// TODO Auto-generated method stub
		
		boolean error = true;
		
		if(error) {
		return	Health.down().withDetail("error Key", 123).build();
		}
		return Health.up().build();
	}

}
