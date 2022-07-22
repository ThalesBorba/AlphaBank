package com.foursys.fourcamp.alphabank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AlphabankApplication implements WebMvcConfigurer {

	public static void main(String[] args) { SpringApplication.run(AlphabankApplication.class, args);}

}
