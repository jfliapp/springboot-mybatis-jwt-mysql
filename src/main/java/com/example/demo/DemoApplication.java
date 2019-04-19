package com.example.demo;

import com.example.demo.filter.JwtAuthenticationFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@MapperScan("com.example.demo.mapper")
@SpringBootApplication
public class DemoApplication {

    // 拦截请求 token 请求里面没有token 都拦截
    @Bean
    public FilterRegistrationBean jwtFilter() {

        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter();
        registrationBean.setFilter(jwtAuthenticationFilter);
        return registrationBean;

    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
