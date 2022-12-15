package org.generation.italy.main.security;

import org.generation.italy.main.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain getFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		
			//cruds for admins
			.requestMatchers("/*/create", "/*/edit/*", "/*/delete/*").hasAuthority("ADMIN")
			//shows for users and admins
			.requestMatchers("/pizza/*", "/drink/*", "/promotion/*", "/ingredient/*").hasAnyAuthority("USER", "ADMIN")
			//indexes for guests
			.requestMatchers("/", "/*", "/general/*").permitAll()
			.and().formLogin()
			.and().logout();
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService getUserDetailsService() {
		return new UserService();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider getAuthProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(getUserDetailsService());
		provider.setPasswordEncoder(getPasswordEncoder());
		
		return provider;
	}
	
}
