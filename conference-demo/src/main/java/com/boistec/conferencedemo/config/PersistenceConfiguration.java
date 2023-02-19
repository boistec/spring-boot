package com.boistec.conferencedemo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    //Uncomment here to override datasource by code or any other common property in the application properties by using @Bean.
//    @Bean
//    public DataSource dataSource() {
//        DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.url("jdbc:postgresql://localhost:5432/conference_app");
//        System.out.println("My custom datasource bean has been initialized and set");
//        return builder.build();
//    }

}
