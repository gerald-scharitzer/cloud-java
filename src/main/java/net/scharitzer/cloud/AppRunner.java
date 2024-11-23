package net.scharitzer.cloud;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

	public static final String USAGE = """
		Usage: java net.scharitzer.cloud.CloudApplication [arguments]
		v
			print version""";

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (args.getSourceArgs().length == 0) {
			System.out.println(USAGE);
		} else if (args.containsOption("v")) {
			System.out.println(CloudApplication.VERSION);
		}
	}
}