package com.dharma.spring.config;


import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.dharma.spring.repositor", entityManagerFactoryRef = "entityManagerFactoryBean")
@PropertySource("classpath:database.properties")
public class DataConfig {
    private final String PROPERTY_DRIVER="driver";
    private final String PROPERTY_URL="url";
    private final String PROPERTY_USER="user";
    private final String PROPERTY_PASSWORD="password";
    private final String PROPERTY_DIALECT="hibernate.dialect";
    private final String PROPERTY_SHOW_SQL="hibernate.show_sql";

    @Autowired
    Environment environment;

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean manager = new LocalContainerEntityManagerFactoryBean();
        manager.setDataSource(dataSource());
        manager.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        manager.setPackagesToScan("com.dharma.spring.model");
        manager.setJpaProperties(hibernateProgs());
        return manager;
    }

    Properties hibernateProgs() {
        Properties properties = new Properties();
        properties.setProperty(PROPERTY_DIALECT,environment.getProperty(PROPERTY_DIALECT));
        properties.setProperty(PROPERTY_SHOW_SQL,environment.getProperty(PROPERTY_SHOW_SQL));

        return properties;

    }

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(environment.getProperty(PROPERTY_DRIVER));
        ds.setUrl(environment.getProperty(PROPERTY_URL));
        ds.setUsername(environment.getProperty(PROPERTY_USER));
        ds.setPassword(environment.getProperty(PROPERTY_PASSWORD));
        return ds;
    }
    @Bean
    JpaTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return transactionManager;
    }


}
