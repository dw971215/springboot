package com.dw.web.moudles.user.personer.controller;

import com.dw.web.common.response.AjaxResponseVo;
import com.dw.web.moudles.user.personer.entity.UserVo;
import com.dw.web.moudles.user.personer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 修改个人信息
 */
@RestController
@RequestMapping("/pt/member")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/updatePersonInfo"})
    @ResponseBody
    public AjaxResponseVo updatePersonInfo(@RequestBody UserVo userVo){

        int a = userService.updatePersonInfo(userVo);
        if(a>0){
            return AjaxResponseVo.of("保存信息成功");
        }else{
            return AjaxResponseVo.fail("保存信息失败");
        }
    }

    /**
     * 修改密码
     * @param userVo
     * @return
     */
    @RequestMapping(value = {"/updatePassWord"})
    @ResponseBody
    public AjaxResponseVo updatePassWord(@RequestBody UserVo userVo){
        int a = userService.updatePassWord(userVo);
        if(a>0){
            return AjaxResponseVo.of("修改密码成功");
        }else{
            return AjaxResponseVo.fail("修改密码失败");
        }
    }
}
