package com.dw.web.moudles.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台登录视图层
 */
@Controller
@RequestMapping(value = {"/pt"})
public class ViewLoginCtroller {

    /**
     * 后台登录页面
     * @return
     */
    @RequestMapping(value = {"/ptViewLogin"})
    public  String viewLogin(){
        return  "login";
    }
}
