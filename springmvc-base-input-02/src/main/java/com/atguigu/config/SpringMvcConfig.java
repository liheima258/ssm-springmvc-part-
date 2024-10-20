package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 功能：学习springmvc ==> 接受数据(参数 路径 json)
 * 日期：2024/8/217:29
 */
@EnableWebMvc //要进行json数据处理,则必须使用此注解,因为他会加入json处理器
@Configuration
@ComponentScan(basePackages = "com.atguigu")
public class SpringMvcConfig implements WebMvcConfigurer {

    // 加了 @EnableWebMvc 则下列两个bean 就不需要手动写了
//    @Bean
//    public HandlerMapping handlerMapping(){
//        return new RequestMappingHandlerMapping();
//    }
//
//    @Bean
//    public HandlerAdapter handlerAdapter(){
//        return new RequestMappingHandlerAdapter();
//    }
}
