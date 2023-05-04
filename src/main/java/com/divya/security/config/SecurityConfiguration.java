package com.divya.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.divya.security.service.UserInfoUserDetailsService;

@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {

	
	@Bean
	public UserDetailsService userDetailsService() {
		
		return new UserInfoUserDetailsService();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(
//						auth -> {
//							auth
//							.anyRequest().authenticated();
//						});
		//to keep application stateless
//		http.sessionManagement(
//				session -> 
//					session.sessionCreationPolicy(
//							SessionCreationPolicy.STATELESS)
//				);
		http.formLogin();
		http.httpBasic();
		http.csrf().disable();
		http.authorizeHttpRequests()
        .requestMatchers("/saveuser").permitAll()
        .and()
        .authorizeHttpRequests().requestMatchers("/employees")
        .authenticated();
		
//		// for h2 database
//		http.headers().frameOptions().sameOrigin();
		return http.build();
	}
	

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
	
}
