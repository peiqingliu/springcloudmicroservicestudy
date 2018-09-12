package com.liupeiqing.spring.cloud.service;

import com.liupeiqing.spring.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author liupeiqing
 * @data 2018/6/26 10:06
 */
@Service
public class RibbonHystrixService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RibbonHystrixService.class);

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallBack")
    public User findUserById(Long id){
        return this.restTemplate.getForObject("http://microservice-provider-user/" + id,User.class);
    }

    /**
     * hystrix fallback方法
     * @return
     */
    public User fallBack(Long id){
        RibbonHystrixService.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
        User user = new User();
        user.setId(-1L);
        user.setUsername("default username");
        user.setAge(0);
        return user;
    }

}
