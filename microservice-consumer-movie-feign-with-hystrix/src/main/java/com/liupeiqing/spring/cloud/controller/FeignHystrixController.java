package com.liupeiqing.spring.cloud.controller;

import com.liupeiqing.spring.cloud.entity.User;
import com.liupeiqing.spring.cloud.feign.UserFeignHystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liupeiqing
 * @data 2018/7/4 13:59
 */
@RestController
public class FeignHystrixController {

    @Autowired
    private UserFeignHystrixClient userFeignHystrixClient;

    @GetMapping("/feign/hystrix/{id}")
    public User findUserById(@PathVariable("id") Long id){
        User user = this.userFeignHystrixClient.findUserById(id);
        return user;
    }

}
