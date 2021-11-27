package com.scx.eduservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @auther scx
 * @date 2021/10/17 - 12:39
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.scx"})
@MapperScan("com.scx.eduservice.mapper")
public class EduApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
