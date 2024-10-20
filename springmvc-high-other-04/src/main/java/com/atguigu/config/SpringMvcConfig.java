package com.atguigu.config;

import com.atguigu.interceptor.Process01Interceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 功能：学习springmvc ==> 全局异常处理+拦截器+参数校验
 * 日期：2024/8/217:29
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.atguigu")
public class SpringMvcConfig implements WebMvcConfigurer {

    //配置jsp对应的视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/",".jsp");
    }

    //开启静态资源处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //将拦截器添加到Springmvc环境,默认拦截所有Springmvc分发的请求
        registry.addInterceptor(new Process01Interceptor());


        /**
         * 精准匹配(指定拦截的路径)
         * addPathPatterns("/common/request/one")
         * 支持 /* 和 /** 模糊路径
         * 例：registry.addInterceptor(new Process01Interceptor())
         *                  .addPathPatterns("/common/request");
         */

        /**
         * 排除匹配(指定不拦截的路径)
         * excludePathPatterns("/common/request/tow")
         * 排除路径,排除应该在拦截的范围内
         * 例： registry.addInterceptor(new Process01Interceptor())
         *                 .addPathPatterns("/common/request")
         *                 .excludePathPatterns("/common/request/tow");
         */

    }

}
