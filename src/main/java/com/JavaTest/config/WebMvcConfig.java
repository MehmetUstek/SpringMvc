package com.JavaTest.config;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.JavaTest.dao.DaoImp;
import com.JavaTest.dao.UserDao;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.JavaTest.controller", "com.JavaTest.dao" })
public class WebMvcConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");

		return vr;
	}

	@Bean
	public DriverManagerDataSource getDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
//		ds.setDriverClassName("");
//		ds.setUrl("");
//		ds.setUsername("root");
//		ds.setPassword("");

		return ds;
	}

	@Bean
	public UserDao getEmployeeDao() {
		return new DaoImp(new DataSource() );
	}

}