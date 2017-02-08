package pl.fiszki.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.fiszki.dao.WordDAO;
import pl.fiszki.dao.WordDAOimpl;

/**
 * Created by Bartek on 30.01.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan("pl.fiszki")
@Import(DatebaseConfig.class)
    public class WebConfig{
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }
    public void configureDefaultServletHandlig(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }

}
