package com.website.tmdt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.website.tmdt.services.StoreageService;

@SpringBootApplication
public class TmdtApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmdtApplication.class, args);
	}
//	
//	@Bean
//	CommandLineRunner init(StoreageService storeageService) {
//		return(args) -> storeageService.init();
//		
//	}

}
