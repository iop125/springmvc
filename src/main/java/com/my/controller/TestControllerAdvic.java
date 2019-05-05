package com.my.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class TestControllerAdvic {

    //应用到所有@RequestMapping注解方法，在其执行之前把返回值放入ModelMap中
    @ModelAttribute
    public Map<String, Object> ma(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "tom");
        return map;
    }

    //应用到所有【带参数】的@RequestMapping注解方法，在其执行之前初始化数据绑定器
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        System.out.println("------------");
    }

    //应用到所有@RequestMapping注解的方法，在其抛出指定异常时执行
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(Exception e) {
        System.out.println("------------");

        return e.getMessage();
    }

}
