package edu.cityu.ds.report.config;

import edu.cityu.ds.report.intercepter.AuthIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthIntercepter()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/login", "/doLogin");
    }
}
