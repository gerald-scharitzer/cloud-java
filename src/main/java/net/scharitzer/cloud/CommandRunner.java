package net.scharitzer.cloud;

import net.scharitzer.cloud.provider.Provider;
import net.scharitzer.cloud.provider.azure.Azure;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner {

	public static final String USAGE = """
		Usage: java net.scharitzer.cloud.Main [arguments]
		
		No arguments prints this usage message.
		
		Arguments:
		
		v
			print version""";

	@Value("${provider}")
	private String providerName;

	@Override
	public void run(String... args) throws Exception {
		if (args.length == 0) {
			System.out.println(USAGE);
			return;
		}

		System.out.println(providerName); // TODO remove

		for (String arg: args) {
			System.out.println(arg); // TODO remove
			if (arg.equals("v")) {
				System.out.println(Main.VERSION);
			}
		}

		Provider provider = new Azure();
		provider.responds();
	}

}
