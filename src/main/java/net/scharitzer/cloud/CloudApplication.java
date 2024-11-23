package net.scharitzer.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudApplication {

	public static final String VERSION = "0.0.1-SNAPSHOT";

	public static void main(String[] args) {
		SpringApplication.run(CloudApplication.class, args);
	}

}
