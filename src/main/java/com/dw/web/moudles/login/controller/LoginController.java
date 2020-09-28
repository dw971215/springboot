package com.dw.web.moudles.login.controller;

import com.dw.web.common.response.AjaxResponseVo;
import com.dw.web.moudles.login.entity.LoginVo;
import com.dw.web.moudles.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/*
 * 后台登录数据处理
 */
@Controller
@RequestMapping("/pt")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = {"/getLogin"})
    @ResponseBody
    public AjaxResponseVo getLoginVo(@RequestBody LoginVo loginVo, HttpServletResponse response){

       LoginVo loginRecVo =  loginService.getLoginVo(loginVo);
       if(loginRecVo==null){
           return AjaxResponseVo.fail("登录失败，请先注册");
       }
       if(!loginRecVo.getPwd().equals(loginVo.getPwd())){
           return AjaxResponseVo.fail("登录密码错误");
       }
        Cookie cookie = null;
        try {
            cookie = new Cookie("name", URLEncoder.encode(loginRecVo.getUname(),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        cookie.setMaxAge(3600);
        cookie.setPath("/");
        response.addCookie(cookie);
        response.addCookie(new Cookie("cardId",loginRecVo.getCardId()));
        return AjaxResponseVo.of("登录成功");
    }


    /**
     * 保存注册信息
     * @param loginVo
     * @return
     */
    @RequestMapping(value = "/saveRegister")
    @ResponseBody
    public AjaxResponseVo saveRegister(@RequestBody LoginVo loginVo,HttpServletResponse response){
        LoginVo loginRecVo =  loginService.getLoginVo(loginVo);
        if(loginRecVo!=null){
            return AjaxResponseVo.fail("用户已存在");
        }
        int a = loginService.saveRegister(loginVo);
        Cookie cookie = new Cookie("cardId",loginVo.getCardId());
        cookie.setMaxAge(3600);
        cookie.setPath("/");
        response.addCookie(cookie);
        if(a>0){
            return AjaxResponseVo.of("注册成功!");
        }else{
            return AjaxResponseVo.fail("注册失败");
        }

    }
}
