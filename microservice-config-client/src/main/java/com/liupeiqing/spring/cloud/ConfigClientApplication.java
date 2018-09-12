package com.liupeiqing.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author liupeiqing
 * @data 2018/6/25 15:56
 */
@SpringBootApplication
public class ConfigClientApplication extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(ConfigClientApplication.class,args);
    }
}
