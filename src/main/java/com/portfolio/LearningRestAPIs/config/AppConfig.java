package com.portfolio.LearningRestAPIs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
    return configuration.getAuthenticationManager();
  }

  // @Bean
  // UserDetailsService userDetailsService() {
  //   UserDetails adminUser = User.withUsername("peter")
  //           .password(passwordEncoder().encode("pass"))
  //           .roles("ADMIN")
  //           .build();

  //   UserDetails patientUser = User.withUsername("patient")
  //           .password(passwordEncoder().encode("pass"))
  //           .roles("PATIENT")
  //           .build();

  //   return new InMemoryUserDetailsManager(adminUser, patientUser);
  // }







}
