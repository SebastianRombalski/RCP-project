package com.example.rcpproject.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
class SecurityConfig {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            PathRequest.H2ConsoleRequestMatcher h2ConsoleRequestMatcher = PathRequest.toH2Console();
            http.authorizeHttpRequests(requests -> requests
                    .requestMatchers("/").permitAll()
                    .requestMatchers(h2ConsoleRequestMatcher).permitAll()
                    .anyRequest().authenticated()
            );
            http.formLogin(login -> login.loginPage("/login").permitAll());
//            http.csrf(csrf -> csrf.ignoringRequestMatchers(h2ConsoleRequestMatcher));
            http.csrf().disable();
            http.headers().frameOptions().sameOrigin();
            return http.build();
        }

    }


