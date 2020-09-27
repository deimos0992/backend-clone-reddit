package com.reddclone.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;

@SpringBootApplication
@EnableAsync
@Import(SpringDataRestConfiguration.class)
public class RedditBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedditBackEndApplication.class, args);
	}

}
