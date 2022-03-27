package com.backend.inctathon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.backend.inctathon.logger.ReportEntityLogger;

@Configuration
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	private ReportEntityLogger reportEntityLogger;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(reportEntityLogger);
	}

}