package com.NetflixCloneProject.Popcorn.Time;

import com.NetflixCloneProject.Popcorn.Time.Service.apiServiceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PopcornTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PopcornTimeApplication.class, args);
	}

}
