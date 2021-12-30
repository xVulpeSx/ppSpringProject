package com.spring.PP;

import com.spring.PP.exception.Handler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjektSpringApplication {

	public static void main(String[] args) {
		Handler	globalExceptionHandler = new Handler();
		Thread.setDefaultUncaughtExceptionHandler(globalExceptionHandler);

		SpringApplication.run(ProjektSpringApplication.class, args);
	}

}
