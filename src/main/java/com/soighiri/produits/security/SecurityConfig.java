package com.soighiri.produits.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.sessionManagement( session ->
                session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS.STATELESS))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests( requests ->
                        requests.requestMatchers("/api/listProduit/**").hasAnyAuthority("ADMIN","USER")
                                .requestMatchers(HttpMethod.GET,"/api/getById/**").hasAnyAuthority("ADMIN","USER")
                                .requestMatchers(HttpMethod.POST,"/api/addProduit/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/api/updateProduit/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"/api/deleteProduit/**").hasAuthority("ADMIN")
                        .anyRequest().authenticated())
                .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
