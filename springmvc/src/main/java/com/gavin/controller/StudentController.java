package com.gavin.controller;

import com.gavin.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    @RequestMapping(value = "/getStudent",method = RequestMethod.GET)
    public ModelAndView getStudent(){
        System.out.println("进入getStudent方法……");
        Student student = new Student();
        student.setId(1);
        student.setName("gavin");
        student.setAge(23);
        // 第一个参数是jsp的名字，第二参数必须是command表示model名
        return new ModelAndView("student","command",student);
    }

    @RequestMapping(value="addStudent",method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("abc")Student student, ModelMap model){
        System.out.println("进入addStudent方法……");
        model.addAttribute("id",student.getId());
        model.addAttribute("name",student.getName());
        model.addAttribute("age",student.getAge());
        return "studentResult";
    }

}
