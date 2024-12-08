package net.scharitzer.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class AppRunner implements ApplicationRunner {

	public static final String USAGE = """
		Usage: java net.scharitzer.cloud.CloudApplication [arguments]
		
		Arguments:
		
		--opts
			print options
		--v
			print version""";

	@Value("${provider}")
	private String provider;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (args.getSourceArgs().length == 0) {
			System.out.println(USAGE);
			return;
		}

		Set<String> optionNames = args.getOptionNames();
		boolean printOptions = args.containsOption("opts");
		for (String optionName: optionNames) {
			if (printOptions) {
				List<String> values = args.getOptionValues(optionName);
				if (values.isEmpty()) {
					System.out.println(optionName); // TODO log level
				} else {
					for (String value : values) {
						System.out.print(optionName); // TODO log level
						System.out.print('=');
						System.out.println(value); // TODO log level
					}
				}
			}
		}

		List<String> nonOptions = args.getNonOptionArgs();
		if (printOptions) {
			for (String nonOption: nonOptions) {
				System.out.println(nonOption);
			}
		}

		if (args.containsOption("v")) {
			System.out.println(CloudApplication.VERSION);
		}

		System.out.println(provider); // TODO remove
	}
}
