package net.scharitzer.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MainTests {

	@Test
	void contextLoads() {
		assertEquals("0.0.1-SNAPSHOT", Main.VERSION);
	}

}
