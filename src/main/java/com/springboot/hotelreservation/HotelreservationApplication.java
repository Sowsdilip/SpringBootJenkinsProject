package com.springboot.hotelreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Hp
 *
 */
/**
 * @author Hp
 *
 */
@SpringBootApplication
@EnableSwagger2
@EnableEncryptableProperties
@EnableWebSecurity

public class HotelreservationApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HotelreservationApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HotelreservationApplication.class);
    }

}
