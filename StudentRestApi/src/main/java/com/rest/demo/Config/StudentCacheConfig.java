package com.rest.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;

@Configuration
public class StudentCacheConfig {

	@Bean
	public Config cacheconfig() {
		return new Config()
				.setInstanceName("hazel-instance")
				.addMapConfig(new MapConfig()
						.setName("Student-cache")
						.setTimeToLiveSeconds(3000));
		
	}
}
