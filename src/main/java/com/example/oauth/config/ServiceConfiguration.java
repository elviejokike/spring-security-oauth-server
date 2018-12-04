package com.example.oauth.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
@Component
@Getter
@Setter
public class ServiceConfiguration {

	private Admin admin;

	@Getter
	@Setter
	public static class Admin {
		private String password;
	}
}
