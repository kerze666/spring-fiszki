package pl.fiszki.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pl.fiszki.config.filters.SetCharacterEncodingFilter;

import javax.servlet.Filter;

/**
 * Created by Bartek on 30.01.2017.
 */

//AbstractAnnotationConfigDispatcherServletInitializer zastępuje nam web.xml
public class FiszkiWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    protected Filter[] getServletFilters(){
        return new Filter[]{new SetCharacterEncodingFilter()};
    }

}
