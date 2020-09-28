package com.dw.web.moudles.index.controller;

import com.dw.web.common.response.AjaxResponseVo;
import com.dw.web.moudles.index.service.IndexService;
import com.dw.web.moudles.user.leavemanagement.dao.LeaveManagementDao;
import com.dw.web.moudles.user.leavemanagement.entity.LeaveVo;
import com.dw.web.moudles.user.personer.entity.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/pt/index/")
public class IndexController {

    @Autowired
    private IndexService indexService;
    /**
     * 获取学生首页近七天的数据
     */
    @RequestMapping(value = "/getStuWeekData")
    @ResponseBody
    public AjaxResponseVo getStuWeekData(String cardId, Model model){

        List<LeaveVo> list = indexService.getStuWeekData(cardId);
        return AjaxResponseVo.of(list);
    }

    /**
     * 获取学生人数
     */
    @RequestMapping(value = "/getTeaClassData")
    @ResponseBody
    public  AjaxResponseVo getTeaClassData(String cardId){

        List<UserVo> list = indexService.getTeaClassData(cardId);
        if(list==null || list.size()<=0){
            UserVo userVo  = new UserVo();
            userVo.setClassInfo("无班级信息");
            userVo.setCounts("0");
        }
        return AjaxResponseVo.of(list);
    }
}
