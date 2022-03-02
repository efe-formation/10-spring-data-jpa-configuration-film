package fr.formation.conf;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:datasource.properties")
@ComponentScan(basePackages = {"fr.formation.service", "fr.formation.controller"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "fr.formation.repository", entityManagerFactoryRef = "emf")
public class ApplicationConfiguration {

	@Autowired
	private Environment env;
	
	@Bean
	protected DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("driver"));
		ds.setUrl(env.getProperty("url"));
		ds.setUsername(env.getProperty("usern"));
		ds.setPassword(env.getProperty("pass"));
		
		return ds;
	}
	
	
	@Bean(name="emf")
	public LocalContainerEntityManagerFactoryBean getEmf() {
		LocalContainerEntityManagerFactoryBean emf = 
				new LocalContainerEntityManagerFactoryBean();
		
		emf.setPackagesToScan("fr.formation.entity");
		emf.setDataSource(getDataSource());
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(false);
		adapter.setDatabase(Database.H2);
		emf.setJpaVendorAdapter(adapter);
		
		Properties props = new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", "create");
		emf.setJpaProperties(props);
		
		return emf;
	}
	
	@Bean(name="transactionManager")
	PlatformTransactionManager getTm() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(getEmf().getObject());
		return manager;
	}
	
}









