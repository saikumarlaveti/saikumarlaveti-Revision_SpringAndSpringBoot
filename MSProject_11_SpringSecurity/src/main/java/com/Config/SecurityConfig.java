package com.Config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // 1. Create users
    @Bean
    public UserDetailsService userDetailsService(
            PasswordEncoder passwordEncoder) {

        UserDetails customer = User.builder()
                .username("customer")
                .password(passwordEncoder.encode("customer123"))
                .roles("CUSTOMER")
                .build();

        UserDetails manager = User.builder()
                .username("manager")
                .password(passwordEncoder.encode("manager123"))
                .roles("CUSTOMER", "MANAGER")
                .build();

        return new InMemoryUserDetailsManager(customer, manager);
    }

    // 2. Password encryption
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 3. Authentication and authorization rules
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth

                .requestMatchers("/", "/home").permitAll()

                .requestMatchers("/offers").authenticated()

                .requestMatchers("/balance")
                    .hasAnyRole("CUSTOMER", "MANAGER")

                .requestMatchers("/loanApprove")
                    .hasRole("MANAGER")

                .requestMatchers("/denied").permitAll()

                .anyRequest().authenticated()
            )

            .httpBasic(Customizer.withDefaults())

            .exceptionHandling(exception -> exception
                .accessDeniedPage("/denied")
            );

        return http.build();
    }
}
