package com.liupeiqing.spring.cloud.controller;

import com.liupeiqing.spring.cloud.domain.User;
import com.liupeiqing.spring.cloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liupeiqing
 * @data 2018/6/22 20:03
 *
 * @Controller和@RestController的区别？
 * 知识点：@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
 *
 *
 *
 * 1) 如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，或者html，
 *   配置的视图解析器 InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 *
 *
 *
 * 2) 如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
 *     如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
 *
 *
 *
 * 例如：
 *
 * 1.使用@Controller 注解，在对应的方法上，视图解析器可以解析return 的jsp,html页面，并且跳转到相应页面
 *
 * 若返回json等内容到页面，则需要加@ResponseBody注解
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DiscoveryClient discoveryClient;  //发现服务

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id){
        User findOne = this.userRepository.findOne(id);
        return findOne;
    }

    @GetMapping("/sayHello")
    public String sayHello(){
        String findOne = this.userRepository.sayHello();
        return findOne;
    }
    /**
     * 本地服务实例的信息
     * @return
     */
    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }

}
