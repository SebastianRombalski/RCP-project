package com.example.rcpproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

@SpringBootApplication
public class RcpProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RcpProjectApplication.class, args);
//        String haslo ="{argon2}" + Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8().encode("password");
//        System.out.println(haslo);
    }

}
