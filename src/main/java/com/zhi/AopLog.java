package com.zhi;

import com.alibaba.fastjson.JSON;
import com.zhi.common.ContextUtils;
import com.zhi.common.IpUtils;
import com.zhi.entity.dto.MyLog;
import com.zhi.entity.dto.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 记录日志操作，是需要写入数据库的操作
 * 使用自定义注释的操作
 */
@Aspect
@Component
@Slf4j
public class AopLog {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation( com.zhi.entity.dto.MyLog)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        //保存日志
        SysLog sysLog = new SysLog();
        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        //获取操作
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            String value = myLog.value();
            sysLog.setOperation(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        sysLog.setMethod(className + "." + methodName);
        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params = JSON.toJSONString(args);
        sysLog.setParams(params);

        sysLog.setCreateDate(sdf.format(new Date()));
        //获取用户名
        sysLog.setUsername("admin");
        //获取用户ip地址
        HttpServletRequest request = ContextUtils.getReq();
        sysLog.setIp(IpUtils.getIpAddr(request));
        log.info("======>记录操作日志！ 操作数据：{}", JSON.toJSONString(sysLog));
    }

}
