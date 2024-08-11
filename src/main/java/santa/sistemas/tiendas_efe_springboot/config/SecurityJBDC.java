package santa.sistemas.tiendas_efe_springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityJBDC {

    @Autowired private DataSource dataSource;

    @Bean
    UserDetailsService userDetailsService() {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        manager.setRolePrefix("ROLE_");
        manager.setUsersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?");
        manager.setAuthoritiesByUsernameQuery("SELECT u.username, r.name as authority " +
                "FROM users u " +
                "JOIN user_roles ur ON u.id = ur.user_id " +
                "JOIN roles r ON ur.role_id = r.id " +
                "WHERE u.username = ?");
        return manager;
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests((request) ->
                        request
                                .requestMatchers("/css/**", "/js/**", "/img/**", "/user/login", "/register", "/user/denied","/").permitAll()
                                .requestMatchers("/*/index").permitAll()
                                .requestMatchers("/*/nuevo").hasRole("ADMIN")
                                .requestMatchers("/*/editar**").hasRole("ADMIN")
                                .requestMatchers("/*/eliminar**").hasRole("ADMIN")
                                .requestMatchers("/*/matricular**").hasAnyRole("ADMIN", "USER")
                                .anyRequest().authenticated()
                )
                .exceptionHandling((exceptionHandling) ->
                        exceptionHandling.accessDeniedPage("/user/denied")
                )
                .formLogin(form ->
                        form
                                .permitAll()
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .loginPage("/user/login")
                                .failureUrl("/user/denied")
                                .loginProcessingUrl("/user/login")
                                .defaultSuccessUrl("/", true)
                )
                .logout(logout -> logout
                        .permitAll()
                        .logoutSuccessUrl("/user/login")
                )
                .build();
    }
}
