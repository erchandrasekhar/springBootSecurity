package com.springbootsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfigration extends WebSecurityConfigurerAdapter
{
	@Autowired
	UserDetailsService userDetailsService;
	
 @Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception 
 {
	auth.userDetailsService(userDetailsService);
 }
 
  @Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests()
		.antMatchers("/resources/**","/static/**").permitAll()
		.antMatchers("/index/", "/home/", "/**").hasAnyAuthority("USER", "ADMIN","DEVELOPER")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").defaultSuccessUrl("/home").permitAll().failureUrl("/login?error=true")
		.and()
		.exceptionHandling().accessDeniedPage("/login")
		.and()
		.logout().permitAll();

	http.csrf().disable();
		
	}
  @Bean
  public PasswordEncoder gPasswordEncoder(){
	  return NoOpPasswordEncoder.getInstance();
  }
}
