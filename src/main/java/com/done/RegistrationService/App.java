package com.done.RegistrationService;

import com.done.RegistrationService.exception.EnvironmentVariableNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class App {
	private static final String PORT_KEY = "PORT";
	private static final String DEFAULT_PORT = "3000";

	public static void main(String[] args) {
		checkEnvironmentVariables();

		String port = getPort();
		SpringApplication app = new SpringApplication(App.class);
		app.setDefaultProperties(
				Map.of(
						"server.port", port
				)
		);
		app.run();
	}

	private static String getPort() {
		if (System.getenv().containsKey(PORT_KEY)) {
			return System.getenv(PORT_KEY);
		}
		return DEFAULT_PORT;
	}

	private static void checkEnvironmentVariables() {
		if (!System.getenv().containsKey("PORT")) {
			throw new EnvironmentVariableNotFoundException("PORT not found");
		}
		if (!System.getenv().containsKey("DB_USERNAME")) {
			throw new EnvironmentVariableNotFoundException("DB_USERNAME not found");
		}
		if (!System.getenv().containsKey("DB_PASSWORD")) {
			throw new EnvironmentVariableNotFoundException("DB_PASSWORD not found");
		}
		if (!System.getenv().containsKey("DB_HOST")) {
			throw new EnvironmentVariableNotFoundException("DB_HOST not found");
		}
		if (!System.getenv().containsKey("DB_NAME")) {
			throw new EnvironmentVariableNotFoundException("DB_NAME not found");
		}
	}
}
