package net.scharitzer.cloud;

import net.scharitzer.cloud.provider.Provider;
import net.scharitzer.cloud.provider.azure.Azure;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

@Component
public class CommandRunner implements CommandLineRunner {

	public static final String USAGE = """
		Usage: java net.scharitzer.cloud.Main [arguments]
		
		No arguments prints this usage message.
		
		Arguments:
		
		i
			read input (default stdin)
		
		v
			print version""";

	private InputStream stdin = System.in;
	private PrintStream stdout = System.out;

	@Value("${provider}")
	private String providerName;

	@Override
	public void run(String... args) throws Exception {
		if (args.length == 0) {
			stdout.println(USAGE);
			return;
		}

		stdout.println(providerName); // TODO remove

		for (String arg: args) {
			stdout.println(arg); // TODO remove
			if (arg.equals("i")) {
				readInput();
			} else if (arg.equals("v")) {
				printVersion();
			}
		}

		Provider provider = new Azure();
		provider.responds();
	}

	private void readInput() throws IOException {
		int bits = stdin.read();
		stdout.println(bits);
	}

	private void printVersion() {
		stdout.println(Main.VERSION);
	}

}
