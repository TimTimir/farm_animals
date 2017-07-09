package net.caimito.membership;

import java.security.Principal;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private DataSource dataSource ;

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			/*
			 * /user should be unprotected so that we can learn about a not logged in user
			 */
			http
			.httpBasic().and()
			.authorizeRequests()
				.antMatchers("/", "/index.html", "/signup.html", "/weeklyPlan.html", "/shoppingList.html", "/login.html", "/user", "/snippets/**", "/recipes", "/recipes/**").permitAll()
				.anyRequest().authenticated()
				.and()
					.csrf().disable();
		}
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
				.dataSource(dataSource)
				.withDefaultSchema()
				.withUser("sns@caimito.net").password("geheim").roles("USER", "ADMIN");
	}
}
