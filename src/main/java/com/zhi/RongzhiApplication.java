package com.zhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ServletComponentScan
@SpringBootApplication
@EnableScheduling
@MapperScan("com.zhi.mapper")
public class RongzhiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RongzhiApplication.class, args);
    }

}

