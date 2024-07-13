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
                .csrf(AbstractHttpConfigurer::disable) // Deshabilitar CSRF
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/send-sms-form", "/send-sms", "/css/**", "/images/**", "/js/**", "/_frag/**", "/smstest").permitAll() // Permitir todos los accesos a recursos estáticos y smstest
                        .anyRequest().authenticated() // Requiere autenticación para todas las demás solicitudes
                );

        return http.build();
    }
}
