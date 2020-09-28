package com.dw.web.moudles.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/pt/test/")
public class TestController {

    @RequestMapping(value = "/getTest")
    public String getTest(){

        return "test/Test";
    }
}
