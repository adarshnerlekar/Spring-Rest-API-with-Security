package com.springRestdatabase3.Sequrity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class AppLicationSequrity 
{
	@Bean
	BCryptPasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService Sequrity()
	{
		User.withUsername("ketan").password(encoder().encode("789")).roles("system").build();
		UserDetails Admin = User.withUsername("Adarsh").password(encoder().encode("123")).roles("admin").build();
		UserDetails user = User.withUsername("Nikhil").password(encoder().encode("456")).roles("user").build();
		
		return new InMemoryUserDetailsManager(Admin,user);
	}
	
	
	@Bean
	public SecurityFilterChain handleService(HttpSecurity http)
	{
		http.authorizeHttpRequests(auth->{
			
			auth.requestMatchers("/balanceUpdate/{id}").hasRole("system");
			auth.requestMatchers("/balanceUpdate/{id}").hasRole("admin");
			auth.requestMatchers("/findall").hasRole("admin");
			auth.requestMatchers("/getbank").hasRole("admin");
			auth.requestMatchers("/bankUpdate").hasRole("admin");
			auth.requestMatchers("/bankRest").hasRole("user");
			auth.requestMatchers("/getbank/{id}").hasAnyRole("admin","user");
		
		}).formLogin(form ->form.permitAll());
		
		return http.build();
	}


}
