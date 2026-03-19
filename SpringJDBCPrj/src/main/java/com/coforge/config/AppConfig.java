package com.coforge.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.coforge")
@EnableWebMvc
@PropertySource("classpath:application.properties")
public class AppConfig {
	@Autowired
	private Environment env;
	@Bean
  public InternalResourceViewResolver viewResolver() {
	  InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	  viewResolver.setPrefix("/WEB-INF/views/");
	  viewResolver.setSuffix(".jsp");
	  return viewResolver;
  }
	@Bean
  public DataSource dataSource() {
	  DriverManagerDataSource ds= new DriverManagerDataSource();
	  ds.setDriverClassName(env.getProperty("db.driver"));
	  ds.setUrl(env.getProperty("db.url"));
	  ds.setUsername(env.getProperty("db.username"));
	  ds.setPassword(env.getProperty("db.password"));
	  return ds;
	  
  }
  @Bean
  public JdbcTemplate jdbcTemplate() {
	  return new JdbcTemplate(dataSource());
  }
  
}
