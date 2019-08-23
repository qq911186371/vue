package com.dennis.controller;

import com.dennis.domain.Result;
import com.dennis.domain.SsCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
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

    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") String id) {
        try {
            String url = "http://localhost:8081/company/" + id;
            Result result = restTemplate.getForObject(url, Result.class);
            return result;
        } catch (RestClientException e) {
            return new Result(true, "查询失败", null);
        }
    }
}
