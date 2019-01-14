package com.zhi;

import com.zhi.controller.inceptor.OneInceptor;
import com.zhi.controller.inceptor.TwoInceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration
public class WebMvcConfiger extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        /**
         * 拦截器按照顺序执行
         */
        registry.addInterceptor(new TwoInceptor()).addPathPatterns("/user/**")
                .addPathPatterns("/task/**");
        registry.addInterceptor(new OneInceptor()).addPathPatterns("/user/**");
        super.addInterceptors(registry);
    }
}
