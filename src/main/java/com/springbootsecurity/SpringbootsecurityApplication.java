package com.springbootsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springbootsecurity.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringbootsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootsecurityApplication.class, args);
		System.out.println("Spring Security Started");
	}

}
