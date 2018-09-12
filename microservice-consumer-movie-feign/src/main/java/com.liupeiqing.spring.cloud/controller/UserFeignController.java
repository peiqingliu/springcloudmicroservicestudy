package com.liupeiqing.spring.cloud.controller;

import com.liupeiqing.spring.cloud.entity.User;
import com.liupeiqing.spring.cloud.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liupeiqing
 * @data 2018/7/3 19:57
 */
@RestController
public class UserFeignController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/feign/{id}")
    public User findUserById(@PathVariable("id") Long id){
        User user = this.userFeignClient.findByIdFeign(id);
        return  user;
    }
}
