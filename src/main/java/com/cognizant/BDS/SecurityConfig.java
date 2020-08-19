 package com.cognizant.BDS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.BDS.security.JwtAuthorizationFilter;
import com.cognizant.BDS.service.AppUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

		
		@Autowired
		AppUserDetailService appUserDetailService;
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			//auth.userDetailsService(inMemoryUserDetailsManager());
			
			auth.authenticationProvider(authProvider());
		}
		
		@Bean
		public DaoAuthenticationProvider authProvider() {
		    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		    authProvider.setUserDetailsService(appUserDetailService);
		    authProvider.setPasswordEncoder(passwordEncoder());
		    return authProvider;
		}

		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

		@Override
		protected void configure(HttpSecurity httpSecurity) throws Exception {
			httpSecurity.cors();
			httpSecurity.csrf().disable().httpBasic().and().authorizeRequests()
					.antMatchers("/authenticate","/").permitAll().anyRequest()
					.authenticated().and()
					.addFilter(new JwtAuthorizationFilter(authenticationManager()));
		}
}
