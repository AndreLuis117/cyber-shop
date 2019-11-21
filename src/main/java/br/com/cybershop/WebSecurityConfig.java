package br.com.cybershop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import br.com.cybershop.service.impl.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
    public WebSecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication()
		.withUser("user").password("user").roles("USER")
		.and()
		.withUser("admin").password("admin").roles("ADMIN");*/
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider
		= new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String[] resources = new String[]{"/resources/**", "/static/**","/webjars/**",
				"/", "/home","/pictureCheckCode","/include/**",
				"/css/**","/icons/**","/images/**","/js/**","/layer/**","/client-auto/new"
				};
		
		http
		.authorizeRequests()
		.antMatchers(resources).permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.successHandler(authenticationSuccessHandler)
		/*.successForwardUrl("/home-admin")
		.defaultSuccessUrl("/home-admin", true)*/
		.permitAll(true);
		
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("client").password("pass").roles("client")
                .and()
                .withUser("admin").password("pass").roles("admin");
    }
}
