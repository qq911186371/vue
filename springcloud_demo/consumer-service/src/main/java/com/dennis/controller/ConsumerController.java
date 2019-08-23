package com.dennis.controller;

import com.dennis.domain.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 李恒
 * @date 2019-08-23 15:53
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public Result findById(@PathVariable("id") String id) {
        String url = "http://company-service/company/" + id;
        Result result = restTemplate.getForObject(url, Result.class);
        return result;
    }

    public Result findByIdFallback(String id) {
        return new Result(false, "远程服务调用失败", null);
    }
}
