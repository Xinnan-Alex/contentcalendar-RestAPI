package com.xinnan.contentcalender;

import com.xinnan.contentcalender.config.ContentCalendarProperties;
import com.xinnan.contentcalender.model.Content;
import com.xinnan.contentcalender.model.Status;
import com.xinnan.contentcalender.model.Type;
import com.xinnan.contentcalender.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository contentRepository){
		return args -> {
			// Insert data into database

			Content content = new Content(
					null,
					"Java Spring Boot Tutorial",
					"Dingi Majingi",
					Status.IDEA,
					Type.VIDEO,
					LocalDateTime.now(),
					null,
					"");

			contentRepository.save(content);
		};
	}

}
