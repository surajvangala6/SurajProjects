package com.rest;

import java.util.Collections;
import java.util.List;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
 
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
 
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rest.entity.*;
import com.rest.service.*;
import com.rest.dao.*;

 
@SpringBootApplication 
@ComponentScan("com")
public class ApiApplication implements CommandLineRunner   {

	@Autowired
	private demoservice demoservice;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/authenticate").allowedOrigins("http://localhost:4200").allowedMethods("GET", "POST","PUT", "DELETE");
			}
		};
	}
	 @Override
	   public void run(String... arg0) throws Exception {
		 getPersonInfoByLastName();
	 }
	 
	 
	private void getPersonInfoByLastName() {
		List<entity> personList = demoservice.getPersonInfoByLastName("Vangala");
		personList.forEach(System.out::println);
	}
	 @Bean
	    public FilterRegistrationBean simpleCorsFilter() {  
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
	        CorsConfiguration config = new CorsConfiguration();  
	        config.setAllowCredentials(true); 
	        // *** URL below needs to match the Vue client URL and port ***
	        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200")); 
	        config.setAllowedMethods(Collections.singletonList("*"));  
	        config.setAllowedHeaders(Collections.singletonList("*"));  
	        source.registerCorsConfiguration("/**", config);  
	        FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
	        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);  
	        return bean;  
	    }  
   
       }

