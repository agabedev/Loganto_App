package pl.myprojects.loganto.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails owner = User.builder()
//                .username("owner")
//                .password("{noop}owner")
//                .roles("OWNER")
//                .build();
//
//        UserDetails propertyManager = User.builder()
//                .username("propertyManager")
//                .password("{noop}manager")
//                .roles("OWNER", "PROPERTY MANAGER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{noop}admin")
//                .roles("OWNER", "PROPERTY MANAGER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin,owner,propertyManager);
//    }




        @Bean
        public UserDetailsManager userDetailsManager(DataSource dataSource) {
            JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
            jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from users where user_id = ?");
            jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id = ?");
        return jdbcUserDetailsManager;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( config ->
                config
                        .requestMatchers(HttpMethod.GET, "/").permitAll()
                        .requestMatchers(HttpMethod.GET, "/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/home").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/pets").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/owner").permitAll()

//
//                        .requestMatchers(HttpMethod.GET, "/api/owners").hasRole("USER")
//                        .requestMatchers(HttpMethod.POST, "/api/owner").hasRole("USER")
//                        .requestMatchers(HttpMethod.POST, "/api/createVet").hasRole("VET")
//                        .requestMatchers(HttpMethod.POST, "/api/createSpeciality").hasRole("ADMIN")
        ).logout( logout -> logout.permitAll());

                http.formLogin(Customizer.withDefaults());
/*                http.formLogin(form -> form
                    .loginPage("/login")
                    .loginProcessingUrl("/authenticateUser")
                    .permitAll());
                http.httpBasic(Customizer.withDefaults());*/

                http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
