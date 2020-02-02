package com.gavin.controller;

import com.sun.tracing.dtrace.ModuleAttributes;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/getValue")
public class RequestValueController {
    // http://localhost:8080/springmvc/getValue/addUser1?username=jack&password=111111
    @RequestMapping("/addUser1")
    public String addUser1(String username,String password) {
        System.out.println("username is:"+username);
        System.out.println("password is:"+password);
        return "showMsg";
    }

    //  http://localhost:8080/springmvc/getValue/param?name=tom
    @RequestMapping("/param")
    public ModelAndView getInfo(@RequestParam("name") String name){
        String str = name + " Spring MVC示例";
        return new ModelAndView("showMsg", "str", str);
    }

    // http://localhost:8080/springmvc/getValue/index/115?name=tom
    @RequestMapping("/index/{pagenum}")
    public String getMessage(@PathVariable("pagenum") String pagenum,ModelMap modelMap){
        modelMap.addAttribute("str",pagenum);
        return "showMsg";
    }

    // http://localhost:8080/springmvc/getValue/header
    @RequestMapping(value = "/header", method = RequestMethod.GET)
    public @ResponseBody String withHeader(@RequestHeader String Accept) {
        return "Obtained 'Accept' header '" + Accept + "'";
    }

    // http://localhost:8080/springmvc/getValue/cookie
    @RequestMapping(value = "/cookie", method = RequestMethod.GET)
    public @ResponseBody String withCookie(@CookieValue String openid_provider) {
        return "Obtained 'openid_provider' cookie '" + openid_provider + "'";
    }

    // http://localhost:8080/springmvc/getValue/body
    @RequestMapping(value = "/body", method = RequestMethod.POST)
    public @ResponseBody String withBody(@RequestBody String body) {
        return "Posted request body '" + body + "'";
    }

    // http://localhost:8080/springmvc/getValue/entity
    @RequestMapping(value = "/entity", method = RequestMethod.POST)
    public @ResponseBody String withEntity(HttpEntity<String> entity) {
        return "Posted request body '" + entity.getBody() + "'; headers = " + entity.getHeaders();
    }

}
