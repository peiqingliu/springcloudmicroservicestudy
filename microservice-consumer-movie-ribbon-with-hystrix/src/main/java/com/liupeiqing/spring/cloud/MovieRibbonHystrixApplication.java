package com.liupeiqing.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 使用@EnableCircuitBreaker注解开启断路器功能
 * @author liupeiqing
 * @data 2018/6/26 9:54
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker  //开启断路器
public class MovieRibbonHystrixApplication extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(MovieRibbonHystrixApplication.class,args);
    }

    /**
     * @LoadBalanced 负载均衡 轮训
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
