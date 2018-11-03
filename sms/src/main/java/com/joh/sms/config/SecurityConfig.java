package com.joh.sms.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.joh.sms.service.AppUserDetailService;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

	public SecurityConfig() {
		logger.info("SecurityConfig->fired");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Autowired
	private AppUserDetailService appUserDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login/**", "/logout", "/").permitAll()
				.antMatchers("/admin/**", "/classGroups/**", "/classGroupTables/**", "/classLevels/**",
						"/classMarks/**", "/classSubjects/**", "/enrollments/**", "/enrollmentPayments/**",
						"/expenses/**", "/lessonTimes/**", "/schoolWeekDays/**")
				.hasRole("ADMIN").antMatchers(HttpMethod.POST, "/studentPresents/**").hasRole("ADMIN")
				.antMatchers("/teachers/**").hasAnyRole("TEACHER","PARENT").antMatchers("/students/**").hasRole("STUDENT")
				.anyRequest().authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/app").and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll().and().exceptionHandling()
				.accessDeniedPage("/WEB-INF/views/accessDenied.jsp").and().csrf().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}

}
