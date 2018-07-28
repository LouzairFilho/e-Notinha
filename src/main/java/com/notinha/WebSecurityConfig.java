package com.notinha;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.
//			authorizeRequests()
//				.anyRequest()
//				.authenticated()
//			.and()
//			.formLogin()
//				.permitAll();
		
		http.userDetailsService(userDetailsService())
				.formLogin()
				.defaultSuccessUrl("/home.jsf")
			.and()
			.csrf().disable()
			.authorizeRequests()
				.anyRequest().authenticated();
	}	

	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails user1 = new User("Louzair", "123", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
		UserDetails user2 = new User("Altair", "123", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
		
		return new InMemoryUserDetailsManager(Arrays.asList(user1,user2));
	}
}
