package com.zhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

// 使用servlet3.0
@ServletComponentScan
@SpringBootApplication
// 定时任务
@EnableScheduling
@MapperScan("com.zhi.mapper")
// 扫描其他的配置文件
@PropertySource(value="classpath:other.properties")
// 开启异步事务
@EnableAsync
public class RongzhiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RongzhiApplication.class, args);
    }

}

