package org.databaseproject.olap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class OLAPDataSourceConfig {

    @Bean(name = "olapDataSource") // Define specific bean name
    public DataSource olapDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/creditcardcompany_dw?zeroDateTimeBehavior=convertToNull")
                .username("root")
                .password("")
                .build();
    }
}

