package ru.bscmsk.todo.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.bscmsk.todo.dao.UserDao;
import ru.bscmsk.todo.enums.UserRole;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .regexMatchers("/tasks.*").hasRole(UserRole.USER.name())
                .regexMatchers("/admin.*").hasRole(UserRole.ADMIN.name())
                .and()
                .formLogin().disable()
                .httpBasic()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


    @Bean
    public UserDetailsService userDetailsService(UserDao userDao) {
        return (username ->
                userDao.findByLogin(username)
                        .map(u -> User.withUsername(u.getLogin())
                                .password(u.getPassword())
                                .roles(u.getRole()).build())
                        .orElseThrow(() -> new UsernameNotFoundException(username)));

    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
