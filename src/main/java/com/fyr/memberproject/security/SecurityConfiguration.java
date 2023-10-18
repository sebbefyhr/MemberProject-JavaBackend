package com.fyr.memberproject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;


@Configuration
public class SecurityConfiguration {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        return new JdbcUserDetailsManager(dataSource);
        /* Till Tomas:
        Den här kommentaren är för eget bruk och skulle självklart inte ligga kvar i ett stort projekt på ett företag.
        Jag har kvar den så jag kan gå tillbaks och se hur man gör/gjorde.

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("SELECT username, password, active FROM users WHERE username =? ");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username =?");
         */
    }


        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

            http.authorizeHttpRequests(configurer ->
                    configurer
                            .requestMatchers(antMatcher(("/h2.console/**")))
                            .permitAll()
                            .requestMatchers(antMatcher(HttpMethod.GET, "/api/admin/members/**")).hasRole("ADMIN")
                            .requestMatchers(antMatcher(HttpMethod.DELETE, "/api/admin/members/**")).hasRole("ADMIN")
                            .requestMatchers(antMatcher(HttpMethod.POST, "/api/admin/members/**")).hasRole("ADMIN")
                            .requestMatchers(antMatcher(HttpMethod.PUT, "/api/admin/members/**")).hasRole("ADMIN")
                            .requestMatchers(antMatcher(HttpMethod.PUT, "/api/mypages/members/**")).hasRole("USER")
                            .requestMatchers(antMatcher(HttpMethod.GET,"/api/mypages/members/**")).hasRole("USER")
                            .anyRequest().authenticated()
                    );

            http.httpBasic(Customizer.withDefaults());
            http.headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer
                    .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
            http.csrf(AbstractHttpConfigurer::disable);

            return http.build();
        }

}