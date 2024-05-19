package spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web
                .ignoring().requestMatchers("/img/**");
    }

    @Bean
    @Order(2)
    public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {

        http
                .securityMatchers(auth -> auth
                        .requestMatchers("/user"));

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user").permitAll());

        http
                .cors(CorsConfigurer::disable);

        http
                .csrf(CsrfConfigurer::disable);

        return http.build();
    }

    @Bean
    @Order(1)
    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {
        http
                .securityMatchers(auth -> auth
                        .requestMatchers("/admin"));
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin").permitAll());

        return http.build();
    }


}
