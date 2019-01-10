package com.zhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@ServletComponentScan
@SpringBootApplication
@EnableScheduling
@MapperScan("com.zhi.mapper")
@PropertySource(value="classpath:other.properties")
public class RongzhiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RongzhiApplication.class, args);
    }

}

