package org.databaseproject.oltp;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "org.databaseproject.oltp.repository",
        entityManagerFactoryRef = "oltpEntityManagerFactory",
        transactionManagerRef = "oltpTransactionManager"
)
public class OLTPJpaConfig {

    @Primary
    @Bean(name = "oltpEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean oltpEntityManagerFactory(
            @Qualifier("oltpDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages("org.databaseproject.oltp.model")
                .persistenceUnit("oltp")
                .build();
    }

    @Primary
    @Bean(name = "oltpTransactionManager")
    public PlatformTransactionManager oltpTransactionManager(
            @Qualifier("oltpEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}

