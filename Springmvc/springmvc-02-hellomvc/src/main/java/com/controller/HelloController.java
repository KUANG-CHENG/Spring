package com.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        // ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();

        // 封装对象，放在 ModelAndView 中
        mv.addObject("message","HelloSpringMVC!");

        // 封装要跳转的视图，放在 ModelAndView 中
        mv.setViewName("hello"); // /WEB-INIF/jsp/hello.jsp
        return mv;
    }
}
