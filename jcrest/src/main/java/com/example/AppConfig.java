package com.example;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Autowired
    DataSourceProperties properties;
    DataSource dataSource;

	  @Bean
	    DataSource realDataSource() {
	        DataSourceBuilder factory = DataSourceBuilder
	                .create()
	                .driverClassName("com.mysql.jdbc.Driver")
	                .url("jdbc:mysql://127.0.0.1:3306/company")
	                .username("root")
	                .password("!zhoska1226");	                
	        this.dataSource = factory.build();
	        return dataSource;
	    }

    @Bean
    @Primary
    DataSource dataSource() {
        return new Log4jdbcProxyDataSource(this.dataSource);
    }
}
