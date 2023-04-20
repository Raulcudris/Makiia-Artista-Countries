package com.makiia.infrastructure.configuration;

import javax.sql.DataSource;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfiguration {
    public static final String JPA_DATASOURCE = "datasource-ebusiness";


    @Bean(name = JPA_DATASOURCE)
    @ConfigurationProperties(prefix = "spring.datasource.db-ebusiness")
    public DataSource dataSourceEbusiness() {
        DataSource datasource = DataSourceBuilder.create().build();

        return datasource;
    }

}
