package stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class StreamApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StreamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Properties props = new Properties();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-pipe");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

		final StreamsBuilder builder = new StreamsBuilder();

		builder.stream("streams-plaintext-input").to("streams-pipe-output");

		final Topology topology = builder.build();

		System.out.println(topology.describe());

		final KafkaStreams streams = new KafkaStreams(topology, props);
		final CountDownLatch latch = new CountDownLatch(1);

		// attach shutdown handler to catch control-c
		Runtime.getRuntime().addShutdownHook(new Thread("streams-shutdown-hook") {
			@Override
			public void run() {
				streams.close();
				latch.countDown();
			}
		});

		try {
			streams.start();
			latch.await();
		} catch (Throwable e) {
			System.exit(1);
		}
		System.exit(0);
	}
}
