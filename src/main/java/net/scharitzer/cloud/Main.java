package net.scharitzer.cloud;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

	public static final String VERSION = "0.0.1-SNAPSHOT";

	@Bean
	public ExitCodeGenerator exitCodeGenerator() {
		return () -> 0;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
		if (context.isClosed()) {
			int status = SpringApplication.exit(context);
			System.exit(status);
		}
	}

}
