package com.portfolio.LearningRestAPIs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

 @Bean
 UserDetailsService userDetailsService() {
   UserDetails adminUser = User.withUsername("peter")
        .password(passwordEncoder.encode("pass"))
       .roles("ADMIN")
       .build();

   UserDetails patientUser = User.withUsername("patient")
       .password(passwordEncoder.encode("pass"))
       .roles("PATIENT")
       .build();

   return new InMemoryUserDetailsManager(adminUser, patientUser);
 }
}
