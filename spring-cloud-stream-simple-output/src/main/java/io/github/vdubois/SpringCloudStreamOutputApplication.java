package io.github.vdubois;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

@SpringBootApplication
@EnableBinding(Source.class)
public class SpringCloudStreamOutputApplication {

	@InboundChannelAdapter(channel = Source.OUTPUT)
	public MyPojo emitData() {
		Faker faker = new Faker();
		return new MyPojo(faker.name().fullName(), faker.address().streetAddress());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamOutputApplication.class, args);
	}
}
