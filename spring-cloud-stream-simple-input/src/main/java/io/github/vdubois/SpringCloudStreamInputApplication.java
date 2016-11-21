package io.github.vdubois;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SpringCloudStreamInputApplication {

	@StreamListener(Sink.INPUT)
	public void log(String data) {
		System.out.println(data);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamInputApplication.class, args);
	}
}
