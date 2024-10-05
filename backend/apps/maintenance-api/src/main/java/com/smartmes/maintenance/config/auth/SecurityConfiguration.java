package com.smartmes.maintenance.config.auth;

import com.smartmes.maintenance.config.auth.firebase.FirebaseTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {

    private final FirebaseTokenFilter firebaseFilter;

    public SecurityConfiguration(FirebaseTokenFilter firebaseFilter) {
        this.firebaseFilter = firebaseFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors(AbstractHttpConfigurer::disable)
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/healthcheck").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(firebaseFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }



}
