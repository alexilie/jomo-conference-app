package com.jomo.conferencedemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {
    @Value("${spring.datasource.url}")
    private String appDatasourceUrl;

    @Value("${spring.datasource.username}")
    private String appDatasourceUsername;

    @Value("${spring.datasource.password}")
    private String appDatasourcePassword;

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        // TODO - remove this code as not secure
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/conference-demo");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("alex1900");

        System.out.println("******* PersistenceConfiguration Datasource has been properly initializer and set*********");
        return dataSourceBuilder.build();
    }
}
