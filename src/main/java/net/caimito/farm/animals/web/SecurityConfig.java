package net.caimito.farm.animals.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/css/**", "/login", "/swagger-resources/**", "/v2/api-docs/**", "/error", "/actuator", "/webjars/**").permitAll()		
				.antMatchers("/api/**").hasRole("USER")
				.antMatchers(HttpMethod.DELETE, "/api/**").hasRole("USER")
				.anyRequest().authenticated()
				.and()
					.formLogin()
				.and()
					.httpBasic();	
	}

	@Profile({"test"})
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("{noop}password").roles("USER");
	}
}