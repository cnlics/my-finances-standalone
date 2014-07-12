package com.rootls;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import com.rootls.common.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luowei on 2014/7/12.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.rootls")
public class MyApplication  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyApplication.class);
    }

    /*
    * 把spring-boot-starter-tomcat与org.apache.tomcat.embed依赖的provied属性去掉，就可以单独跑了 ;
    * <packaging>war</packaging> 改成 <packaging>jar</packaging> ;
    * mvn package ; 运行：java -jar xxxxx.jar ;
    * */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyApplication.class, args);
    }

    @Bean
    protected ServletContextListener config(){
        return new Config();
    }

    @Bean
    public FilterRegistrationBean characterEncodingFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.addUrlPatterns("/*");
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        registrationBean.setFilter(new CharacterEncodingFilter());
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean siteMeshFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.addUrlPatterns("/*");
        registrationBean.setFilter(new SiteMeshFilter());
        registrationBean.setOrder(2);
        return registrationBean;
    }

}
