package com.zhi.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(value = Exception.class)
    public Object errHand(HttpServletRequest req, HttpServletResponse rep, Exception e)throws Exception{
        e.printStackTrace();
        if(isAjax(req)) {
            return "error";
        }
        ModelAndView mdv = new ModelAndView();
        mdv.addObject("message", e.getMessage());
        mdv.addObject("url", req.getRequestURL());
        mdv.setViewName("error");
        return mdv;
    }

    public static boolean isAjax(HttpServletRequest req){
        return (req.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(req.getHeader("X-Requested-With").toString()));
    }
}
