package com.fyr.memberproject.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import static org.junit.jupiter.api.Assertions.*;

class SecurityConfigurationTest {

    @Test
    void userDetailsManager() {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();//dataSource);
        userDetailsManager.setUsersByUsernameQuery("SELECT username, password, active FROM users WHERE username =? ");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username =?");

    }

    @Test
    void defaultSecurityFilterChain() {
    }
}