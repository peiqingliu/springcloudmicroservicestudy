package com.liupeiqing.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 *
 * @EnableFeignClients  开启feign
 * @EnableHystrixDashboard 开启dashboard
 * @EnableCircuitBreaker  开启断路器
 * @author liupeiqing
 * @data 2018/7/4 13:54
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker
public class MovieFeignHystrixStreamApplication extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(MovieFeignHystrixStreamApplication.class,args);
    }
}
