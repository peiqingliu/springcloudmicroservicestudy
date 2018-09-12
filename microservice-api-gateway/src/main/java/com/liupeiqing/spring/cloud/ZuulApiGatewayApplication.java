package com.liupeiqing.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author liupeiqing
 * @data 2018/7/5 16:13
 *
 *  使用@EnableZuulProxy注解激活zuul。
 *  跟进该注解可以看到该注解整合了@EnableCircuitBreaker、@EnableDiscoveryClient，是个组合注解，目的是简化配置。
 *
 *
 *  测试
 * 启动microservice-api-gateway项目。还记得我们之前访问通过http://localhost:8000/1去访问microservice-provider-user服务中id=1的用户信息吗？
 *
 * 我们现在访问http://localhost:8050/microservice-provider-user/1试试。会惊人地看到：
 *
 * {"id":1,"username":"Tom","age":12}
 * 这不正是microservice-provider-user服务中id=1的用户信息吗？
 *
 * 所以我们可以总结出规律：访问
 *
 * http://GATEWAY:GATEWAY_PORT/想要访问的Eureka服务id的小写/**
 * ，将会访问到
 *
 * http://想要访问的Eureka服务id的小写:该服务端口/**
 *
 * 例如本例  http://localhost:8006/microservice-provider-user/2
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApiGatewayApplication {
    public static void main(String[] args){
        SpringApplication.run(ZuulApiGatewayApplication.class,args);
    }
}
