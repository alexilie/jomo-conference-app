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
        dataSourceBuilder.url("jdbc:postgresql://ec2-107-23-76-12.compute-1.amazonaws.com:5432/dai0lecjnptsjb");
        dataSourceBuilder.username("vicqkvnveokqnf");
        dataSourceBuilder.password("d4ca9b2386d0032f56f947413db9d1fd255c54745977b3dd12f3f62868015c94");

        System.out.println("******* Heroku PostgreSQL instance - PersistenceConfiguration Datasource has been properly initializer and set*********");
        return dataSourceBuilder.build();
    }
}
