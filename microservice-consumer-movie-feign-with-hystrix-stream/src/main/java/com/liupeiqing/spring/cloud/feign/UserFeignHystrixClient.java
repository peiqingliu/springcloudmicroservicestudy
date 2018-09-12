package com.liupeiqing.spring.cloud.feign;

import com.liupeiqing.spring.cloud.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liupeiqing
 * @data 2018/7/4 13:59
 */
@FeignClient(name = "microservice-provider-user", fallback = UserFeignHystrixClient.HystrixClientFallback.class)
public interface UserFeignHystrixClient {

    @RequestMapping("/{id}")
    public User findUserById(@RequestParam("id") Long id);


    /**
     * @component （把普通pojo实例化到spring容器中，相当于配置文件中的
     * <bean id="" class=""/>）
     *
     * 这边采取了和Spring Cloud官方文档相同的做法，将fallback类作为内部类放入Feign的接口中，当然也可以单独写一个fallback类。
     */
    @Component
    static class HystrixClientFallback implements UserFeignHystrixClient{
        private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

        /**
         * fallback 方法
         * @param id
         * @return
         */
        @Override
        public User findUserById(Long id) {
            LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
            User user = new User();
            user.setId(-1L);
            user.setUsername("default username");
            user.setAge(0);
            return user;
        }
    }
}
