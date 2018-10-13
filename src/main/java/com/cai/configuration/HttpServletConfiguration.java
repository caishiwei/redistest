package com.cai.configuration;

import com.cai.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpServletConfiguration {

	@Bean
	public ServletRegistrationBean myServlet(){
		ServletRegistrationBean myServlet = new ServletRegistrationBean(new MyServlet());
		myServlet.addUrlMappings("/login");
		return myServlet;
	}
}
