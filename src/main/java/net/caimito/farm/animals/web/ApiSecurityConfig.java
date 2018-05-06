package net.caimito.farm.animals.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	  protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.antMatcher("/api/**")
			.authorizeRequests()
			.antMatchers(HttpMethod.DELETE).authenticated()
			.antMatchers(HttpMethod.PUT).authenticated()
			.anyRequest().authenticated()
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
