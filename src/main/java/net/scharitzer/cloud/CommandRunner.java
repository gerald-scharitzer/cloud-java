package net.scharitzer.cloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CommandRunner implements CommandLineRunner {

	public static final String USAGE = """
		Usage: java net.scharitzer.cloud.CloudApplication [arguments]
		
		No arguments prints this usage message.
		
		Arguments:
		
		v
			print version""";

	@Override
	public void run(String... args) throws Exception {
		runCommands(Arrays.asList(args));
	}

	public void runCommands(Iterable<String> commands) {
		for (String command: commands) {
			System.out.println(command); // TODO remove
			if (command.equals("v")) {
				System.out.println(CloudApplication.VERSION);
			}
		}
	}

}
