package com.example.yang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//扩展springmvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override   // 处理跨域
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") //设置允许跨域请求的域名
                .allowedMethods("GET", "POST", "HEAD", "PUT", "DELETE", "OPTIONS") //设置允许的方法
                .allowCredentials(true) //是否允许证书
                .maxAge(3600) //配置客户端缓存预检请求的响应时间，单位是秒
                .allowedHeaders("*");
    }


}
