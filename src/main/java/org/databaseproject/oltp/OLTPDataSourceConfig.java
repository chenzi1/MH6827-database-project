package org.databaseproject.oltp;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OLTPDataSourceConfig {

    @Bean(name = "oltpDataSource") // Define specific bean name
    public DataSource oltpDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/creditcardcompany?zeroDateTimeBehavior=convertToNull")
                .username("root")
                .password("")
                .build();
    }
}

