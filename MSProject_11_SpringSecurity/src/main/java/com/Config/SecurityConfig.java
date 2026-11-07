
package com.Config;

import javax.sql.DataSource;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.HttpSessionEvent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
public class SecurityConfig {

    // 1. Password Encoder
    // Supports passwords stored as {bcrypt}HASH
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // 2. JDBC-based UserDetailsService
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {

        JdbcUserDetailsManager manager =
                new JdbcUserDetailsManager(dataSource);

        manager.setUsersByUsernameQuery(
            "SELECT username, password, enabled " +
            "FROM users WHERE username = ?"
        );

        manager.setAuthoritiesByUsernameQuery(
            "SELECT username, authority " +
            "FROM authorities WHERE username = ?"
        );

        return manager;
    }

    // 3. Session Registry
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    // 4. Session Event Publisher
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    // 5. Spring Security Configuration
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            UserDetailsService userDetailsService,
            SessionRegistry sessionRegistry) throws Exception {

        http

            // Authorization
            .authorizeHttpRequests(auth -> auth

                // Allow internal JSP forwards and error dispatches
                .dispatcherTypeMatchers(
                    DispatcherType.FORWARD,
                    DispatcherType.ERROR
                ).permitAll()

                // Public URLs
                .requestMatchers(
                    "/", "/home", "/login", "/denied"
                ).permitAll()

                // Authenticated users
                .requestMatchers("/offers")
                    .authenticated()

                // Customer or Manager
                .requestMatchers("/balance")
                    .hasAnyRole("CUSTOMER", "MANAGER")

                // Only Manager
                .requestMatchers("/loanApprove")
                    .hasRole("MANAGER")

                // All other URLs
                .anyRequest()
                    .authenticated()
            )

            // Form Login
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login?error=true")
                .permitAll()
            )

            // Remember Me
            .rememberMe(remember -> remember
                .key("my-unique-remember-me-key")
                .tokenValiditySeconds(86400)
                .userDetailsService(userDetailsService)
            )

            // Session Management
            .sessionManagement(session -> session

                // Session fixation protection
                .sessionFixation(fixation ->
                    fixation.changeSessionId()
                )

                // Maximum two simultaneous sessions per user
                .maximumSessions(2)
                    .maxSessionsPreventsLogin(true)
                    .sessionRegistry(sessionRegistry)
            )

            // Access Denied
            .exceptionHandling(exception -> exception
                .accessDeniedPage("/denied")
            )

            // Logout
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID", "remember-me")
                .permitAll()
            );

        return http.build();
    }
}
