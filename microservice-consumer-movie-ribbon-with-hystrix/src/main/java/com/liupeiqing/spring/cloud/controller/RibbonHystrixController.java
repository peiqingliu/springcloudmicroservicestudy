package com.liupeiqing.spring.cloud.controller;

import com.liupeiqing.spring.cloud.entity.User;
import com.liupeiqing.spring.cloud.service.RibbonHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liupeiqing
 * @data 2018/6/28 9:48
 */
@RestController
public class RibbonHystrixController {

    @Autowired
    private RibbonHystrixService ribbonHystrixService;

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id){
        return  this.ribbonHystrixService.findUserById(id);
    }
}
