package com.magazinejornada.api.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http//.csrf().disable()
                .authorizeRequests()
                //.antMatchers("/animes/admin/**").hasRole("ADMIN")
                //.antMatchers("/animes/**").hasRole("USER")
                //.antMatchers("/actuator/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //.formLogin()
                //.and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        log.info("Password encoded {}", passwordEncoder.encode("passwordMagazine"));

        auth.inMemoryAuthentication()
                .withUser("customer")
                .password(passwordEncoder.encode("passwordMagazine"))
                .roles("CUSTOMER")
                .and()
                .withUser("partner")
                .password(passwordEncoder.encode("passwordMagazine"))
                .roles("PARTNER");

        /*auth.userDetailsService(devDojoUserDetailsService)
                .passwordEncoder(passwordEncoder);*/
    }

}
