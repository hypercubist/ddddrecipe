package com.ddddrecipe.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                    .antMatchers("/testdb/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .headers().frameOptions().sameOrigin()
                .and()
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
