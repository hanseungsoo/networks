package io.human.networks.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.human.networks.controller.response.ErrorResponse;
import io.human.networks.repository.UserRepository;
import io.human.networks.security.JWTAuthenticationFilter;
import io.human.networks.security.JWTAuthorizationFilter;
import io.human.networks.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;
    private ObjectMapper mapper;
    private UserRepository userRepository;

    public WebSecurityConfig(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.mapper = new ObjectMapper();
        this.userRepository = userRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors()
            .and()
            .csrf()
                .disable()
            .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user")
                    .permitAll()
            .anyRequest()
                .authenticated()
            .and()
            .addFilter(new JWTAuthenticationFilter(authenticationManager()))
            .addFilter(new JWTAuthorizationFilter(authenticationManager(), userRepository))
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .exceptionHandling()
                .authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse, AuthenticationException ex) throws IOException, ServletException {
                        ErrorResponse errorResponse = new ErrorResponse();
                        errorResponse.setException(ex.getClass().getName());
                        errorResponse.setMessage(ex.getMessage());
                        errorResponse.setPath(httpServletRequest.getServletPath());
                        errorResponse.setTimestamp(new Date());

                        httpServletResponse.setContentType("application/json");

                        mapper.writeValue(httpServletResponse.getOutputStream(),
                            new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED));
                    }
                })
        ;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService).passwordEncoder(bCryptPasswordEncoder());
    }
}
