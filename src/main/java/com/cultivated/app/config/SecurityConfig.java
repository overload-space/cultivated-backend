package com.cultivated.app.config;

import com.cultivated.app.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Value("${server.session.cookie.name}")
    private String cookieName;

    @Value("${security.enable}")
    private boolean securityEnable;

    private static final String LOGIN = "/login";
    private static final String LOGOUT = "/logout";

    @Resource
    private AccountService accountService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if (securityEnable) {
            http.authorizeRequests()
                    .antMatchers(
                            "/healthcheck",
                            "/beans",
                            "/v2/api-docs",
                            "/swagger-resources/**",
                            "/swagger-resources",
                            "/configuration/security",
                            "/swagger-ui.html",
                            "/webjars/**",
                            "/swagger-resources/configuration/ui").permitAll()
                    .anyRequest().authenticated();
        } else {
            http.authorizeRequests().anyRequest().permitAll();
        }

        // disable CSRF protection
        http.csrf().disable();

        http.logout()
                .logoutUrl(SwaggerConfig.API_V1 + LOGOUT)
                .logoutSuccessUrl(SwaggerConfig.API_V1 + LOGIN)
                .invalidateHttpSession(true)
                .deleteCookies(cookieName);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService);
    }
}
