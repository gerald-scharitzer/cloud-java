package net.scharitzer.cloud;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class WebApi {
	@RequestMapping("/")
	String root() { // FIXME not found
		return "root";
	}
}
