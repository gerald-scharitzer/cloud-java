package net.scharitzer.cloud.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RootTest {

	@Test
	public void getRoot() {
		Root root = new Root();
		assertEquals("root", root.getValue());
	}

}
