package edu.nju.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import edu.nju.web.interceptor.LoginInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login");
//                .excludePathPatterns("/loginVerify")
//                .excludePathPatterns("/landing")
//                .excludePathPatterns("/register")
//                .excludePathPatterns("/registerVerify");
        registry.addInterceptor(new LoginInterceptor())
                  .addPathPatterns("/ask")
                  .addPathPatterns("/saveAnswer");
    }


    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(3000000);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**");
    }

}
