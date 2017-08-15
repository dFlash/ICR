package com.mg.icr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class RDBConfig {

    @Autowired
    private Environment env;

    @Bean
    public JpaTransactionManager jpaTransactionManager(){
        JpaTransactionManager jtManager = new JpaTransactionManager(
                getEntityManagerFactoryBean().getObject());
        return jtManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(getDataSource());
        entityManagerFactory.setPersistenceUnitName("unitLocal");
        LoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
        entityManagerFactory.setLoadTimeWeaver(loadTimeWeaver);
        entityManagerFactory.setJpaProperties(hibernateProperties());
        entityManagerFactory.setPackagesToScan("com.mg.icr.model");
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabasePlatform(env.getProperty("hibernate.dialect"));
        entityManagerFactory.setJpaVendorAdapter(adapter);
        return entityManagerFactory;
    }

    @Bean()
    public DataSource getDataSource()
    {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(env.getProperty("db.driverName"));
        ds.setUrl(env.getProperty("db.url"));
        ds.setUsername(env.getProperty("db.username"));
        ds.setPassword(env.getProperty("db.password"));
        return ds;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        return properties;
    }

}
