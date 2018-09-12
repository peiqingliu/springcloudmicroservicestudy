package com.liupeiqing.spring.cloud.controller;

import com.liupeiqing.spring.cloud.entity.User;
import com.liupeiqing.spring.cloud.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liupeiqing
 * @data 2018/6/26 9:32
 */
@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;

    @GetMapping("/{id}")
    public User findUserByid(@PathVariable(value = "id") Long id){
        return ribbonService.findUserById(id);
    }
}
