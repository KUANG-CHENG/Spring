package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/HelloController")
public class HelloController {

    // 真实访问地址: localhost:8080/HelloController/hello
    @RequestMapping("/hello")
    public String sayHello(Model model){
        // 向模型中添加属性值message，可以与JSP页面中取出并渲染
        model.addAttribute("message","Hello SpringMVC!!!");
        // WEB-INF/jsp/hello.jsp
        return "hello";
    }
}
