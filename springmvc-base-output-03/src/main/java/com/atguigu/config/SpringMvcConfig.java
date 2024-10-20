package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 功能：学习springmvc ==> 响应数据
 * 日期：2024/8/217:29
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.atguigu")
public class SpringMvcConfig implements WebMvcConfigurer {
    //配置jsp对应的视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //快速配置jsp模板语言
        registry.jsp("/WEB-INF/views/",".jsp");
    }

    //开启静态资源处理
    //先找是否有对应路径的方法，有就运行方法，没有就找有没有对应路径的静态资源，有就显示静态资源，如果都没有，则404
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
