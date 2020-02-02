package com.gavin.controller;

import com.gavin.exception.MyException;
import com.gavin.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping(method=RequestMethod.GET)
    public String printHello(ModelMap model){
        System.out.println("进入printHello方法……");
        model.addAttribute("message","Hello Spring MVC Framework!");
        return "hello";
    }

    //重定向,会自动带上/hello路径
    @RequestMapping(value="/redirect", method = RequestMethod.GET)
    public String redirect(){
        return "redirect:finalRedirect";
    }
    @RequestMapping(value="/finalRedirect", method = RequestMethod.GET)
    public String finalRedirect(){
        return "finalRedirect";
    }

    //重定向到静态页面,需要在ContextConfigLocation中配置静态路径映射
    @RequestMapping(value="/staticPage", method = RequestMethod.GET)
    public String staticPage(){
        return "redirect:/static/staticPage.html";
    }

    //自定义异常跳转
    @RequestMapping(value="/getException", method = RequestMethod.GET)
    public String getException(@RequestParam(value = "name",required = false)String name){
        if(StringUtils.isEmpty(name)){
            throw new NullPointerException("默认异常");
        }
        if(name.length()>2){
            throw new MyException("自定义异常");
        }
        return "hello";
    }
}
