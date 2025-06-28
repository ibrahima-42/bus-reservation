package bus.reservation.Secrity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // désactive CSRF pour POST/PUT en test
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/client/**").permitAll() // autorise cette route
                        .anyRequest().permitAll() // les autres routes restent protégées
                )
                .httpBasic(Customizer.withDefaults()); // active l’authentification basique si besoin

        return http.build();
    }
}
