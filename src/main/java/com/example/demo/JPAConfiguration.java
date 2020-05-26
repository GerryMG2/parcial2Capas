package com.example.demo;



import java.util.Properties;

import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
public class JPAConfiguration {
	
	@Bean
//	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		
		em.setPersistenceUnitName("capas");
		em.setPackagesToScan("com.example.demo");
		
		JpaVendorAdapter vda = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vda);
		em.setJpaProperties(HibernateProperties());
		
	
		
		
		
		return em;
	}
	
	
	
	@Bean
//	@Primary
	public DataSource dataSource() {
		System.out.println("url:");
		System.out.println(System.getenv("URI_POSTGRES"));
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl(System.getenv("URI_POSTGRES"));
		dataSource.setUsername(System.getenv("POSTGRES_USER"));
		System.out.println(System.getenv("POSTGRES_USER"));
		System.out.println(System.getenv("POSTGRES_PASS"));
		dataSource.setPassword(System.getenv("POSTGRES_PASS"));
		
		return dataSource;
	}
	
	public Properties HibernateProperties () {
		Properties pro = new Properties();
		pro.setProperty("hibernate.show_sql", "true");
		pro.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		
		return pro;
		
	}
	
	
//	  @Primary
//	    @Bean
//	    public PlatformTransactionManager importanciaTransactionManager() {
//	  
//	        JpaTransactionManager transactionManager
//	          = new JpaTransactionManager();
//	        transactionManager.setEntityManagerFactory(
//	        		EntityManagerFactory().getObject());
//	        return transactionManager;
//	    }

}
