package com.wql.educationservice;

import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 * @author wql
 * @version 1.0
 * @date 2020/4/13 21:16
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.wql"})//配置包扫描规则(这样才能赵傲 swagger)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        System.out.println("启动成功");
    }
}
