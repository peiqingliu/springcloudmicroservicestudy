package com.liupeiqing.spring.cloud.service;

import com.liupeiqing.spring.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author liupeiqing
 * @data 2018/6/25 20:53
 */
@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    public User findUserById(Long id){
        //服务提供者  http://服务提供者的serviceId/url
        return this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
    }
}
