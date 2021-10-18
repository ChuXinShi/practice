package com.scx.oss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author: scx
 * @Date 2021/10/18 8:15
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.scx")
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class,args);
    }
}
