package santa.sistemas.tiendas_efe_springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityJBDC {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
            User.withUsername("user")
                .password(passwordEncoder.encode("user"))
                .roles("USER")
                .build(),
            User.withUsername("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("USER", "ADMIN")
                .build()
        );
    }
    
    //UserDetailsService userDetailsService() {
    //JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
    //manager.setRolePrefix("ROLE_");
    //manager.setUsersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?");
    //manager.setAuthoritiesByUsernameQuery("SELECT u.username, r.name as authority " +
    //        "FROM users u " +
    //        "JOIN user_roles ur ON u.id = ur.user_id " +
    //        "JOIN roles r ON ur.role_id = r.id " +
    //        "WHERE u.username = ?");
    //return manager;
    //}
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .httpBasic(withDefaults())
            .authorizeHttpRequests((request) -> 
                request
                    .requestMatchers("/css/**", "/images/**", "/js/**", "/login", "/signup", "/user/denied").permitAll()
                    .requestMatchers("/index").hasAnyRole("ADMIN", "USER")
                    .requestMatchers("/user/add", "/user/edit/**", "/user/delete/**").hasRole("ADMIN")
                    .requestMatchers("/product/index").hasAnyRole("ADMIN", "USER")
                    .anyRequest().authenticated()
            )
            .exceptionHandling((exceptionHandling) -> 
                exceptionHandling
                    .accessDeniedPage("/user/denied")
            )
            .formLogin((form) -> 
                form
                    .permitAll()
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginPage("/login")
                    .failureUrl("/login?error=true")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/index", true)
            )
            .logout((logout) -> 
                logout
                    .permitAll()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout=true")
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
            )
            .build();
    }
}
