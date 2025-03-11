package net.scharitzer.cloud;

import net.scharitzer.cloud.provider.Provider;
import net.scharitzer.cloud.provider.azure.Azure;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class CommandRunner implements CommandLineRunner {

	public static final String USAGE = """
		Usage: java net.scharitzer.cloud.Main [arguments]
		
		No arguments prints this usage message.
		
		Arguments:
		
		i
			read input (default stdin)
		
		v
			print version
		
		w
			start web server""";

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
			} else if (arg.equals("w")) {
				startWebServer();
			}
		}

		Provider provider = new Azure();
		provider.responds();
	}

	private void readInput() throws IOException {
		InputStreamReader chars = new InputStreamReader(stdin);
		BufferedReader text = new BufferedReader(chars);
		String line = text.readLine();
		while (line != null) {
			stdout.println(line); // TODO read yaml instead
			line = text.readLine();
		}
	}

	private void printVersion() {
		stdout.println(Main.VERSION);
	}

	private void startWebServer() {
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		WebServer server = factory.getWebServer();
		server.start();
		stdout.println("TODO web server");
	}

}
