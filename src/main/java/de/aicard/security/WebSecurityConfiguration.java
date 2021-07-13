package de.aicard.security;

import lombok.AllArgsConstructor;
import org.bouncycastle.jcajce.provider.digest.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Autowired
    UserDetailsService userDetailsService;
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        // TODO : Error Controller + 404 + 503
        http.authorizeRequests()
                .antMatchers("/createLearnset", "/learnSets", "/profile", "/profile/**",
                             "/deckOverview/**").hasAnyRole("USER")
                
                .antMatchers("/","/index", "/login", "/registration").permitAll()
                
                .and()
                .formLogin()
                    .loginPage("/login") // use GetMapping in LoginController
                    .usernameParameter("email").passwordParameter("password")
                    .defaultSuccessUrl("/learnSets") // if Login was successful, go to Startpage
                    .permitAll()
                
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/index")
                ;
    }
    
    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        // TODO : Use an Encoder

        return new BCryptPasswordEncoder();// NoOpPasswordEncoder.getInstance();

    }
   
}
