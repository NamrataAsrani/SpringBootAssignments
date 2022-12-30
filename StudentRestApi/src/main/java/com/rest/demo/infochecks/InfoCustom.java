package com.rest.demo.infochecks;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Component;

@Component
public class InfoCustom implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		// TODO Auto-generated method stub
		
boolean error = true;
		
		if(error) {
			builder.withDetail("error Key", 123).build();
		}
		
		builder.build();

	}

}
