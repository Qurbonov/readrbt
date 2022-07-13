package uz.atm.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import uz.atm.config.filter.JwtFilter;
import uz.atm.exceptions.AppForbiddenException;
import uz.atm.services.auth.AuthUserService;

/**
 * Author: Khonimov Ulugbek
 * Date: 06/07/22
 * Time: 10:47
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthUserService authUserService;

    private final JwtFilter jwtFilter;

    private static final String[] AUTH_BLACKLIST={
            "/v1/atm/auth/**",
            "/v1/atm/black/list/add",
            "/v1/atm/black/list/remove/**"

    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {

        try {
            auth.userDetailsService(authUserService)
                    .passwordEncoder(getPasswordEncoder());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) {
        http.addFilterBefore(
                jwtFilter,
                UsernamePasswordAuthenticationFilter.class);
        try {
            http.authorizeRequests()
                    .antMatchers(AUTH_BLACKLIST).authenticated()
                    .anyRequest().permitAll();
            http.cors().and().csrf().disable();
        } catch (Exception e) {
            throw new AppForbiddenException(e.getMessage());
        }

    }
}
