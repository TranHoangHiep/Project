package com.hoanghiep.webtravel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:config.xml")
public class WebTravelApplication {

	public static void main(String[] args) {
	    SpringApplication.run(WebTravelApplication.class, args);
	}
}
