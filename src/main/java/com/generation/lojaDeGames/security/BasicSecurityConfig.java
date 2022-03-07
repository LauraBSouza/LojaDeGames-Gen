package com.generation.lojaDeGames.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		
		 auth.userDetailsService(userDetailsService);

		 auth.inMemoryAuthentication()
			.withUser("root")
			.password(passwordEncoder().encode("root"))
			.authorities("ROLE_USER");

	}

	/**
	 *  A annotation @Bean transforma a instância retornada pelo método como um 
	 *  objeto gerenciado pelo Spring, desta forma, ele pode ser injetado em qualquer
	 *  classe, a qualquer momento que você precisar sem a necessidade de usar a 
	 *  annotation @Autowired
	 * 
	 *  O método abaixo é responsável por criptografar a senha do usuário utilizando o
	 *  método hash Bcrypt.
	 */
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 *  Sobrescreve (@Override) o segundo método Configure que é responsável por
	 *  criar uma instância da Classe HttpSecurity, que permite configurar a 
	 *  segurança baseada na web para solicitações http específicas (endpoints)
	 */
	
	 @Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		 
		http.authorizeRequests()
			.antMatchers("/usuarios/logar").permitAll()
			.antMatchers("/usuarios/cadastrar").permitAll()
			.antMatchers("/usuarios/produtos").permitAll()
			.antMatchers(HttpMethod.OPTIONS).permitAll()
			.anyRequest().authenticated()
			.and().httpBasic()
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().cors()
			.and().csrf().disable();
			
	}
}
