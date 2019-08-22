package com.dennis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 李恒
 * @date 2019-08-22 15:46
 */
@SpringBootApplication
@MapperScan(basePackages = "com.dennis.dao")
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }
}
