package com.canteen.canteenms.config;
//Spring Security Configuration File

//Required Imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecConfig extends WebSecurityConfigurerAdapter{
    
	
	//Object of UserDetails Class in Service Package to provide authentication
    @Autowired
    private UserDetailsService userDetailsService;
    
    
    //Object of Success Handler class in Configuration Package to Handle Success after successful authentication
    @Autowired
    private SimpleAuthenticationSuccessHandler successHandler;
    
    
    //Configure method provides the authentication manager
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncode());
        
        
    }
    
    
    //Configure method for security configuration
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/index","/register","/js/**", "/css/**","/images/**","/user/viewuserorder","/user/cancelorder")
        .permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/index")
                .loginProcessingUrl("/dologin")
                .successHandler(successHandler)
                .and().logout().logoutSuccessUrl("/")
                .permitAll();
        
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
    
    
    //Password encoder
    @Bean
    public PasswordEncoder getPasswordEncode() {
        //return NoOpPasswordEncoder.getInstance();
    	return new BCryptPasswordEncoder(10);
    	
    }
}