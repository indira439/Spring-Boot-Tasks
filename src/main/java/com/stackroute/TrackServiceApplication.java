package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**Enables Spring Boot auto configuration and component scanning.*/
@SpringBootApplication
public class TrackServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(TrackServiceApplication.class, args);
    }

}
