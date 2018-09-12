package com.liupeiqing.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;


// @EnableAsync // 开始对异步任务的支持，并在相应的方法中使用@Async注解来声明一个异步任务
@EnableTransactionManagement  // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
//@EnableDiscoveryClient
// 其实用更简单的话来说，就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，
// 如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。
//@EnableEurekaClient  //服务发现注解
@SpringBootApplication
@EnableDiscoveryClient
public class UserApplication extends SpringBootServletInitializer {  //SpringBootServletInitializer的执行过程，简单来说就是通过SpringApplicationBuilder构建并封装SpringApplication对象，并最终调用SpringApplication的run方法的过程。

    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(UserApplication.class);
    }

    public static void main(String[] args){
        SpringApplication.run(UserApplication.class);
    }

}
