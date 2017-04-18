package pl.fiszki.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.fiszki.service.impl.UserDetailsServiceImpl;


/**
 * Created by Bartek on 15.04.2017.
 */

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = UserDetailsServiceImpl.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .and()
                .authorizeRequests().antMatchers("/user/**").access("hasRole('ROLE_USER')")
                .and()
                .logout().logoutSuccessUrl("/homepage").logoutUrl("/logout")
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/user-info")
                .and()
                .exceptionHandling();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }
}
