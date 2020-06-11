/*package config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.rest")
@PropertySource("application.properties")
@EnableJpaRepositories(
        basePackages = "com.rest",
        entityManagerFactoryRef = "secondEntityManager",
        transactionManagerRef = "secondTransactionManager")
public class DatabaseSecond {
	
	 @Value("${dummy.datasource.driver-class-name}")
	    private String driverdummy;
	    @Value("${dummy.datasource.url}")
	    private String urldummy;
	    @Value("${dummy.datasource.username}")
	    private String usernamedummy;
	    @Value("${dummy.datasource.password}")
	    private String passworddummy;
	    @Value("${spring.jpa.properties.hibernate.dialect}")
	    private String dialect;
	    @Value("${spring.jpa.show-sql}")
	    private boolean showSQL;
	    @Value("${spring.jpa.properties.hibernate.format_sql}")
	    private boolean formatSQL;
	    @Value("${entitymanager.packages.to.scan}")
	    private String packageScan;
	    @Value("${connection.release_mode}")
	    private String releaseMode;
	    
    @Bean(name = "secondDataSource")
    public DataSource secondDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverdummy);
        dataSource.setUrl(urldummy);
        dataSource.setUsername(usernamedummy);
        dataSource.setPassword(passworddummy);
        return dataSource;
    }

    @Bean(name = "secondEntityManager")
    public LocalContainerEntityManagerFactoryBean secondEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(secondDataSource());
        em.setPackagesToScan(new String[] { packageScan });
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());

        return em;
    }

    @Bean(name = "secondTransactionManager")
    public PlatformTransactionManager secondTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(secondEntityManager().getObject());
        return transactionManager;
    }

    @Bean(name = "secondSessionFactory")
    public LocalSessionFactoryBean secondSessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(secondDataSource());
        sessionFactoryBean.setPackagesToScan(packageScan);
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", true);
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
        properties.put("hibernate.show_sql",showSQL);
        properties.put("hibernate.format_sql",formatSQL);
        properties.put("entitymanager.packages.to.scan",packageScan);
        properties.put("connection.release_mode",releaseMode);
        return properties;
    }

}*/
