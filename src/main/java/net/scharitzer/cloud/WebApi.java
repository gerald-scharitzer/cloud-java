package net.scharitzer.cloud;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
public class WebApi {
	String root() { // FIXME not found
		return "root";
	}
}
