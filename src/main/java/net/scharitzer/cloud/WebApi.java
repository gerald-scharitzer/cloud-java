package net.scharitzer.cloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebApi {
	@RequestMapping("/")
	public String root() {
		return "root";
	}
}
