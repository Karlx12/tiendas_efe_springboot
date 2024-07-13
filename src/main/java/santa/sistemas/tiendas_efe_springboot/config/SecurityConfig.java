package santa.sistemas.tiendas_efe_springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Deshabilitar CSRF
                .authorizeHttpRequests(authorize -> authorize
                        //.requestMatchers("/","/send-sms-form", "/send-sms").permitAll() // Permitir acceso sin autenticación
                        .anyRequest().authenticated() // Requiere autenticación para todas las demás solicitudes

                ).formLogin(form -> form
                .loginPage("/login") // Ruta personalizada para el login
                .defaultSuccessUrl("/", true) // Redirigir a la raíz después de login exitoso
                .permitAll()
        )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Ruta personalizada para el logout
                        .logoutSuccessUrl("/login?logout") // Redirigir a la página de login después del logout
                        .permitAll()
                );

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}

