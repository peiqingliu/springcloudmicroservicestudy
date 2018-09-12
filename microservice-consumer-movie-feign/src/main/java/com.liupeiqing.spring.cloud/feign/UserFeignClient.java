package com.liupeiqing.spring.cloud.feign;

import com.liupeiqing.spring.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用@FeignClient("microservice-provider-user")注解绑定microservice-provider-user服务，还可以使用url参数指定一个URL。
 * @author liupeiqing
 * @data 2018/7/3 19:53
 */
@FeignClient("microservice-provider-user")
public interface UserFeignClient {

    /**
     * /{id}  要和提供者controller 的路径一致
     *  如果提供者那边的路径是  userService/getUser/{userId}
     *  那么这边 就要 这么写@RequestMapping(value = "userService/getUser/{userId}", method = RequestMethod.GET)
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public User findByIdFeign(@RequestParam("id") Long id);
}

