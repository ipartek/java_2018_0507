/*package com.ipartek.formacion.springrestcrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableWebSecurity(debug = true)
public class Login extends WebSecurityConfigurerAdapter {
  /*  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
              //  .antMatchers("/").permitAll()  //No dejar a todos
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

   
    
    @Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth.jdbcAuthentication()
		.usersByUsernameQuery(
				"user")
			//"select email,password, 1 from usuario where email=?")
		.authoritiesByUsernameQuery(
				"user");
			//"select email,'ROLE_USER' from usuario where email=?");
	}	
    
    */
