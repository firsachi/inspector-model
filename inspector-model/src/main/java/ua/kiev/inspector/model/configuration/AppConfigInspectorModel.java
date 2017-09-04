package ua.kiev.inspector.model.configuration;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import ua.kiev.inspector.model.dao.DaoFactory;

@Configuration
@ComponentScan("ua.kiev.inspector.model.dao.impl")
@PropertySource("classpath:SettingsPool.properties")
@EnableTransactionManagement
public class AppConfigInspectorModel {
	
	@Autowired
    private Environment env;
	
	@Bean
	public DaoFactory daoFactory() {
		DaoFactory factory = DaoFactory.getInstance();
		return factory;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[]{"ua.kiev.inspector.model.entity"});
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.default_shema", "public");
		properties.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
		return properties;
	}
	
	@Bean
	public LazyConnectionDataSourceProxy dataSource(){
		LazyConnectionDataSourceProxy dataSource = new LazyConnectionDataSourceProxy(templateDataSource());
		return dataSource;
	}
	
	@Bean
	public ComboPooledDataSource templateDataSource(){
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("org.postgresql.Driver");
			dataSource.setJdbcUrl(env.getProperty("datasource.jdbcUrl"));
			dataSource.setUser(env.getProperty("datasource.userdb"));
			dataSource.setPassword(env.getProperty("datasource.password"));
			dataSource.setMaxPoolSize(new Integer(env.getProperty("datasource.maxPoolSize")));
			dataSource.setMinPoolSize(new Integer(env.getProperty("datasource.minPoolsize")));
			dataSource.setMaxStatements(100);
			//dataSource.setIdleConnectionTestPeriod(3600);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return dataSource;
	}

}
