package com.boot.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.boot.service.StudentService;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class DefaultConfig extends WebMvcConfigurerAdapter  {
	
	   @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	
	
	@Bean
	public StudentService studentService(){
		
		return new StudentService();
	}
	
}
