package com.cg.secureapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Autowired private UserDetailsService userDetailsService;
	 */
	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Not necessary if use OAuth2
	@Bean
	public AuthenticationProvider authProvider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		// provider.setUserDetailsService(userDetailsService);
		provider.setUserDetailsService(userDetailsService());
		// provider.setPasswordEncoder(new BCryptPasswordEncoder());
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	// customize login page
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// OAuth2
		// http.csrf().disable().authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated();

		http.csrf().disable().authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated().and()
				.formLogin().loginPage("/login").permitAll().and().logout().invalidateHttpSession(true)
				.clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/loguot-success").permitAll();
	}

	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() {
	 * 
	 * List<UserDetails> users = new ArrayList<>();
	 * users.add(User.withDefaultPasswordEncoder().username("myUser").password(
	 * "1234").roles("USER").build());
	 * 
	 * return new InMemoryUserDetailsManager(users); }
	 */
}
