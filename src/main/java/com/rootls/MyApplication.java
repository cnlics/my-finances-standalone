package com.rootls;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import com.rootls.common.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.batch.JobExecutionExitCodeGenerator;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.w3c.dom.Element;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luowei on 2014/7/12.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.rootls")
@PropertySource(value = {"classpath:application.properties", "classpath:config/config.properties"})
public class MyApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyApplication.class);
    }

    static ApplicationContext applicationContext = null;
    /*
    * 把spring-boot-starter-tomcat与org.apache.tomcat.embed依赖的provied属性去掉，就可以单独跑了 ;
    * mvn package ; 运行：java -jar xxxxx.war ;
    * */
    public static void main(String[] args) throws Exception {
//        SpringApplication.run(MyApplication.class, args);

        final Frame frame = new Frame("My Finances Analysis(http://rootls.com)");

        Panel head = new Panel();
        Label label = new Label("Start & Stop Application", Label.CENTER);
        head.add(label, BorderLayout.NORTH);

        Panel body = new Panel();
        body.setLayout(new GridLayout(1, 2, 10, 10));
        final Button startBtn = new Button("Start");
        final Button stopBtn = new Button("Stop");
        stopBtn.disable();
        body.add(startBtn);
        body.add(stopBtn);


        final String[] argsFinal = args;
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applicationContext = SpringApplication.run(MyApplication.class, argsFinal);
                startBtn.disable();
                stopBtn.enable();
            }
        });
        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpringApplication.exit(applicationContext,new JobExecutionExitCodeGenerator());
                startBtn.enable();
                stopBtn.disable();
            }
        });

        frame.add(head,BorderLayout.NORTH);
        frame.add(body);
        frame.setSize(300, 100);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    //在监听器类上加上@Component注解，就不需要这样手动注入了
//    @Bean
//    protected ServletContextListener config(){
//        return new Config();
//    }

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
//        ConfigurableSiteMeshFilter siteMeshFilter = new ConfigurableSiteMeshFilter() {
////            @Override
////            protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
//////                super.applyCustomConfiguration(builder);
////                builder.addDecoratorPath("/*", "/WEB-INF/decorators/main.jsp")
////                        .addExcludedPath("/resources/*")
////                        .addExcludedPath("/user/login*")
////                        .addExcludedPath("/test*");
////            }
//
//            @Override
//             protected Element loadConfigXml(FilterConfig filterConfig, String configFilePath) throws ServletException {
//                return super.loadConfigXml(filterConfig, "decorators.xml");
//            }
//        };
        SiteMeshFilter siteMeshFilter = new SiteMeshFilter();
        registrationBean.setFilter(siteMeshFilter);
        registrationBean.setOrder(2);
        return registrationBean;
    }

}
