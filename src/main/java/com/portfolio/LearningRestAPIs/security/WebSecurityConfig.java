package com.portfolio.LearningRestAPIs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

  private final PasswordEncoder passwordEncoder;
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .authorizeHttpRequests(auth ->auth
          .requestMatchers("/public/**").permitAll()
          .requestMatchers("/admin/**").hasRole("ADMIN")
          .requestMatchers("/doctors/**").hasAnyRole("DOCTOR", "ADMIN")
          //  .requestMatchers("/admin/**").authenticated()
        )
        .httpBasic(Customizer.withDefaults());
      return httpSecurity.build();
  }
}
