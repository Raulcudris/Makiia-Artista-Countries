package com.makiia.infrastructure.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication(scanBasePackages = {
		"com.makiia.infrastructure",
		"com.makiia.modules",
		"com.makiia.crosscutting"})
@EnableJpaRepositories(basePackages = {
		"com.makiia.crosscutting.persistence.repository"})
@EntityScan(basePackages = "com.makiia.crosscutting.persistence.entity")
@EnableWebMvc
public class HomepageArtistApplication {

	public static void main(final String[] args) {
		SpringApplication.run(HomepageArtistApplication.class, args);
	}

}
