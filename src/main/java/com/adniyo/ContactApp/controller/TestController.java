package com.adniyo.ContactApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test/hell")
    public String helloWorld(){
        return "hello" ; // -> /WEB-INF/view/hello.jsp
    }

}
