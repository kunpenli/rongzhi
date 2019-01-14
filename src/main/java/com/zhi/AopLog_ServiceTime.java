package com.zhi;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 记录service运行时间的操作日志
 */
@Aspect
@Component
@Slf4j
public class AopLog_ServiceTime {

    @Pointcut("execution(* com.zhi.service..*.*(..))")
    public void performance() {
    }

    @Around("performance()")
    public Object doLog(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        // 定义返回对象、得到方法需要的参数
        Object resultData = null;
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        String method_name = method.getName();
        try {
            // 调用接口
            log.info("======>请求[service]接口开始！ 方法{}, 参数:{}", method_name, args);
            resultData = joinPoint.proceed(args);
            long endTime = System.currentTimeMillis();
            log.info("======>请求[service]接口完成！ 方法{}, 耗时:{},返回:{}", method_name, (endTime - startTime), resultData);
        } catch (Throwable e) {
            // 记录异常信息
            long endTime = System.currentTimeMillis();
            log.error("======>请求[xxx]接口异常！ 方法{}, 耗时:{}", method_name, (endTime - startTime));
        }
        return resultData;
    }

}
