package es.vito.project.springboot.reuniones.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/*").hasRole("API_USER")
                .requestMatchers("/*").authenticated()
        )
                .formLogin(login -> login
                .loginPage("/login").permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails usuario1 = User.builder().username("granJefe")
                .password(passwordEncoder().encode("SHHHHHH"))
                .roles("USER", "API_USER").build();
        UserDetails usuario2 = User.builder().username("Vitorinete")
                .password(passwordEncoder().encode("Pasacampeon"))
                .roles("USER").build();
        return new InMemoryUserDetailsManager(usuario1, usuario2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
    }
}
