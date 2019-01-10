package com.zhi.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(value = Exception.class)
    public Object errHand(HttpServletRequest req, HttpServletResponse rep, Exception e, Map<String, Object> modelMap)throws Exception{
        e.printStackTrace();
        if(isAjax(req)) {
            return "error";
        }
        modelMap.put("message", e.getMessage());
        modelMap.put("url", req.getRequestURL());
        return "error";
    }

    public static boolean isAjax(HttpServletRequest req){
        return (req.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(req.getHeader("X-Requested-With").toString()));
    }
}
