package com.dw.web.moudles.user.personer.controller;

import com.dw.web.moudles.user.personer.entity.UserVo;
import com.dw.web.moudles.user.personer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 个人信息视图层
 */
@Controller
@RequestMapping(value ="/pt/member")
public class ViewUserController {

    @Autowired
    private UserService userService;


    /**
     * 个人信息页面
     * @param
     * @return
     */
    @RequestMapping(value ="/getPersoner")
    public String getUser(HttpServletRequest request, String cardId,HttpServletResponse response, Model model){
        UserVo user = new UserVo();
        user.setCardId(cardId);
        UserVo userVo = userService.getUserVo(user);
        if("".equals(userVo.getSex())||userVo.getSex()==null){
            userVo.setSex("0");
        }
        if("".equals(userVo.getIdentity())||userVo.getIdentity()==null){
            userVo.setIdentity("0");
        }
        model.addAttribute("userVo",userVo);
        return "manager/personInfo";
    }


    @RequestMapping(value = "/changePassWord")
    public String changePassWord(String cardId,Model model){
        UserVo user = new UserVo();
        user.setCardId(cardId);
        UserVo userVo = userService.getUserVo(user);
        model.addAttribute("userVo",userVo);
        return "changepwd";
    }

}
