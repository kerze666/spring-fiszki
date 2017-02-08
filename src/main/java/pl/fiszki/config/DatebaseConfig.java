package pl.fiszki.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Bartek on 01.02.2017.
 */
@Configuration
@ComponentScan(value = "pl.fiszki")
@EnableTransactionManagement
public class DatebaseConfig {
    @Bean
    public LocalEntityManagerFactoryBean factoryBean(){
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("localEntity");
        return factoryBean;
    }
    @Bean
    public JpaTransactionManager jpaTransactionManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(factoryBean().getObject());
        jpaTransactionManager.setPersistenceUnitName("localEntity");
        return jpaTransactionManager;
    }

}
