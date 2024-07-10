package santa.sistemas.tiendas_efe_springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Deshabilitar CSRF para permitir solicitudes POST sin un token CSRF
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/","/send-sms-form", "/send-sms").permitAll() // Permitir acceso sin autenticación
                        .anyRequest().authenticated() // Requiere autenticación para todas las demás solicitudes
                );

        return http.build();
    }
}
