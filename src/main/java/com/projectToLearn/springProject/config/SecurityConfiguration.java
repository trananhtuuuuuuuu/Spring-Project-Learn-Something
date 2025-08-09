package com.projectToLearn.springProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean 
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    http
    .csrf(csrf -> csrf.disable())
    .authorizeHttpRequests(
      requests -> requests
      .requestMatchers(HttpMethod.POST, "/api/admin/**").permitAll()
      .requestMatchers("/", "/api/admin/**").permitAll()
      .requestMatchers(HttpMethod.POST, "/login").permitAll()
      .anyRequest().authenticated()
    )
    // .oauth2ResourceServer((oauth2) -> oauth2
    //   .jwt(Customizer.withDefaults())
    //.authenticationEntryPoint(customAuthenticationEntryPoint)
    .exceptionHandling(
          exceptions -> exceptions
                  .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint()) //401
                   .accessDeniedHandler(new BearerTokenAccessDeniedHandler())) //403

    .formLogin(f -> f.disable())
    .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );
    return http.build();
  }



  

  
}
