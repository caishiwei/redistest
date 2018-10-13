package com.cai.configuration;

import com.cai.filter.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class HttpFilterConfiguration {

	@Bean
	public FilterRegistrationBean xssFilter(){
		FilterRegistrationBean xssFilterRegister = new FilterRegistrationBean(new XssFilter());
		xssFilterRegister.addUrlPatterns("/");
		return xssFilterRegister;
	}
	@Bean
	public FilterRegistrationBean characterEncodingFilter(){
		FilterRegistrationBean characterEncodingFilter = new FilterRegistrationBean(new CharacterEncodingFilter());
		characterEncodingFilter.addUrlPatterns("/");
		characterEncodingFilter.addInitParameter("encoding","UTF-8");
		characterEncodingFilter.addInitParameter("forceEncoding","true");
		return characterEncodingFilter;
	}
}
