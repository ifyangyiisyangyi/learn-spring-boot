package com.example.yang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

//扩展springmvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

//    @Bean
//    public ViewResolver myViewResoler(){
//        return new MyViewResolver();
//    }
    @Override   // 处理跨域
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") //设置允许跨域请求的域名
                .allowedMethods("GET", "POST", "HEAD", "PUT", "DELETE", "OPTIONS") //设置允许的方法
                .allowCredentials(true) //是否允许证书
                .maxAge(3600) //配置客户端缓存预检请求的响应时间，单位是秒
                .allowedHeaders("*");
    }

//    public static class MyViewResolver implements ViewResolver{
//        @Override
//        public View resolveViewName(String viewName, Locale locale) throws Exception{
//            return null;
//        }
//    }
}
