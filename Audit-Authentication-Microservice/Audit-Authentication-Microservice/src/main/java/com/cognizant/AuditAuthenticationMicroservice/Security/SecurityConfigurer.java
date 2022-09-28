package com.cognizant.AuditAuthenticationMicroservice.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//import com.cognizant.AuditAuthenticationMicroservice.Filter.JwtFilter;
import com.cognizant.AuditAuthenticationMicroservice.Service.UserDetailsServiceClass;

/**
 * 
 * @author garik
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceClass service;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/**
		 * configure Authenticate Manager so that it knows where to load Using
		 * BcryptPasswordEncoder
		 */
		auth.userDetailsService(service).passwordEncoder(passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/**
		 * This method is used to authorize the requests
		 */
		http.csrf().disable().headers().frameOptions().disable().and().authorizeRequests().antMatchers("/authenticate")
				.permitAll().antMatchers("/register").permitAll().antMatchers("/**").permitAll().
				// any other request need to be authenticated
				anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);

	}

	/**
	 * creating bean of authentication manager
	 */
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * 
	 * @return PasswordEncoder Bean
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
