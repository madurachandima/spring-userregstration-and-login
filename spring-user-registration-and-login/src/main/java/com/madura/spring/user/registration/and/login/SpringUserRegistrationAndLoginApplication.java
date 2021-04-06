package com.madura.spring.user.registration.and.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringUserRegistrationAndLoginApplication {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "true");
        SpringApplication.run(SpringUserRegistrationAndLoginApplication.class, args);
    }

}
