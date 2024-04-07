package org.databaseproject.olap;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "org.databaseproject.olap",
        entityManagerFactoryRef = "olapEntityManagerFactory",
        transactionManagerRef = "olapTransactionManager"
)
public class OLAPJpaConfig {

    @Bean(name = "olapEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean olapEntityManagerFactory(
            @Qualifier("olapDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages("org.databaseproject.olap.model")
                .persistenceUnit("olap")
                .build();
    }

    @Bean(name = "olapTransactionManager")
    public PlatformTransactionManager olapTransactionManager(
            @Qualifier("olapEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }
}

