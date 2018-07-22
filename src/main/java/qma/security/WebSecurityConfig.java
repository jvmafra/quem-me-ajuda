package qma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configurable
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private JWTTokenProvider jwtTokenProvider;
  
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		// starts authorizing configurations
		.authorizeRequests()
		//Alowing some url's
		.antMatchers("/login").permitAll()
		.antMatchers("/signup").permitAll()
		.antMatchers("v2/api-docs").permitAll()
		// authenticate all remaining URLS
		.antMatchers("/aluno").access("hasRole('ROLE_ALUNO') or hasRole('ROLE_TUTOR')")
		.antMatchers("/tutor").access("hasRole('ROLE_ALUNO') or hasRole('ROLE_TUTOR')")
		.antMatchers(HttpMethod.GET, "/horario").access("hasRole('ROLE_ALUNO') or hasRole('ROLE_TUTOR')")
		.antMatchers(HttpMethod.POST, "/horario").access("hasRole('ROLE_TUTOR')")
		.antMatchers(HttpMethod.GET, "/local").access("hasRole('ROLE_ALUNO') or hasRole('ROLE_TUTOR')")
		.antMatchers(HttpMethod.POST, "/local").access("hasRole('ROLE_TUTOR')")
		.anyRequest().fullyAuthenticated().and()
		// adding JWT filter
		.addFilterBefore(new JWTFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
		// enabling the basic authentication
		.httpBasic().and()
		// configuring the session as state less. Which means there is
		// no session in the server
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		// disabling the CSRF - Cross Site Request Forgery
		.csrf().disable();
		
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManager() ;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}

}
