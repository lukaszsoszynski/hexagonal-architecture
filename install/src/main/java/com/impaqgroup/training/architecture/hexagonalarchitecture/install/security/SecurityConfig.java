package com.impaqgroup.training.architecture.hexagonalarchitecture.install.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import static java.util.Objects.nonNull;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ForumUserDetailService  forumUserDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers(POST,"/users" ).permitAll()
                .anyRequest().authenticated()
            .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(STATELESS)
            .and()
                .anonymous()
            .and()
                .httpBasic().realmName("forum");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(forumUserDetailService).passwordEncoder(noopPasswordEncoder());
    }

    private PasswordEncoder noopPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                // very dangerous should not be used on production system
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return nonNull(charSequence) && charSequence.toString().equals(s);
            }
        };
    }

}
