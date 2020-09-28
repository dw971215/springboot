package com.dw.web.moudles.user.gatecard.controller;

import com.dw.web.moudles.index.service.IndexService;
import com.dw.web.moudles.login.entity.LoginVo;
import com.dw.web.moudles.user.personer.entity.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/pt/gateCard")
public class ViewGateCardController {

    @Autowired
    private IndexService indexService;
    @RequestMapping(value ="/index")
    public String getUser(HttpServletRequest request, String cardId, HttpServletResponse response, Model model){

        LoginVo loginVo = indexService.getLoginVo(cardId);
        if("0".equals(loginVo.getIdentity())){
            return "manager/gateCard";
        }else{
            return "manager/gateTeaCard";
        }

    }

}
