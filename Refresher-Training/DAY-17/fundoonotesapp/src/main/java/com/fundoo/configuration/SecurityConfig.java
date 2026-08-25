package com.fundoo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fundoo.security.JwtAuthFilter;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
	private final JwtAuthFilter jwtAuthFilter;

//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		UserDetails admin = User.builder().username("admin").password("{noop}admin123").roles("ADMIN").build();
//			
//		UserDetails user = User.builder().username("user").password("{noop}user123").roles("USER").build();
//		
//		return new InMemoryUserDetailsManager(admin, user);
//		
//	}
//	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//		
//		http.authorizeHttpRequests(auth -> auth
//				
//				.requestMatchers("/public").permitAll()
//				.requestMatchers("/admin").hasRole("ADMIN")
//				.requestMatchers("/user").hasRole("USER")
//				.anyRequest().authenticated()
//		).httpBasic(Customizer.withDefaults());
//		return http.build();
//		
//	}
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			
			http
				.csrf(csrf -> csrf.disable())
				.sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth
				.requestMatchers("/auth/register","/auth/login","/auth/forgot-password","/auth/reset-password").permitAll()
				.anyRequest().authenticated())
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
			return http.build();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
	
	
}
