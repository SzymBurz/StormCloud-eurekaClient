package com.wtd.client;

import com.netflix.discovery.EurekaClient;
import com.wtd.client.controller.GreetingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class eurekaClientApplication implements GreetingController {

	@Autowired
	@Lazy
	private EurekaClient eurekaClient;

	@Value("${spring.application.name}")
	private String appName;

	@Value("${user.role}")
	private String role;

	public static void main(String[] args) {
		SpringApplication.run(eurekaClientApplication.class, args);
	}

	@Override
	public String greeting() {
		return String.format(
				"Hello from '%s'!", eurekaClient.getApplication(appName).getName());
	}

	@Override
	public String whoami(String username) {
		return String.format("Hello! You're %s and you're a(n) %s...\n", username, role);
	}

}
