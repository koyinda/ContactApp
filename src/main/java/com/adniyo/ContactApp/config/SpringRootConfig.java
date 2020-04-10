package com.adniyo.ContactApp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.adniyo.ContactApp.dao","com.adniyo.ContactApp.service"})
public class SpringRootConfig {
	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(System.getenv().get("db.driverClass"));
		ds.setUrl(System.getenv().get("db.connectionURL"));
		ds.setUsername(System.getenv().get("db.username"));
		ds.setPassword(System.getenv().get("db.password"));
		ds.setMaxTotal(5);
		ds.setInitialSize(1);
		ds.setTestOnBorrow(true);
		ds.setValidationQuery("Select 1");
		ds.setDefaultAutoCommit(true);
		
		
		
		return ds;
	}

}
