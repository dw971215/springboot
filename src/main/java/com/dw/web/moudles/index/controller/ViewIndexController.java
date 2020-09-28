package com.dw.web.moudles.index.controller;

import com.dw.web.moudles.index.service.IndexService;
import com.dw.web.moudles.login.entity.LoginVo;
import com.dw.web.moudles.user.leavemanagement.entity.LeaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pt")
public class ViewIndexController {

    @Autowired
    private IndexService indexService;

    private final String ZERO = "0";

    /**
     * 主框架页面
     * @param cardId
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = {"/index"})
    public String getIndex(String cardId, HttpServletRequest request, HttpServletResponse response, Model model){
        LoginVo loginVo = indexService.getLoginVo(cardId);
        model.addAttribute("loginVo",loginVo);
        return "manager/index";
    }

    /**
     * 主框架的首页面
     * @return
     */
    @RequestMapping(value = "/mainHomePage")
    public String mainHomePage(String cardId,Model model){
        LoginVo loginVo = indexService.getLoginVo(cardId);
        String stuNum="";
        String teaNum="";
        List<LeaveVo> stuList = new ArrayList<LeaveVo>();
        List<LeaveVo> teaList = new ArrayList<LeaveVo>();
        if(ZERO.equals(loginVo.getIdentity())){
                //学生
            stuNum =  indexService.getStuCount(cardId);
            /**
             * 获取学生请假信息
             */
            stuList =  indexService.getStuList(cardId);

        }else{
            teaNum = indexService.getTeaCount(cardId);
            teaList = indexService.getTeaList(cardId);
        }
        /**
         * 用户总量数据统计
         */
        String countNum = indexService.getCount();
        /**
         * 今日新增用户
         */
        String countTodayNum = indexService.getTodayCount();
        if(countTodayNum==null || "".equals(countTodayNum)){
            countTodayNum ="0";
        }
        if(stuNum==null||"".equals(stuNum)){
            stuNum=ZERO;
        }
        if(teaNum==null||"".equals(teaNum)){
            teaNum=ZERO;
        }
        if(stuList==null||stuList.size()<=0){
            stuList = new ArrayList<>();
            LeaveVo leaveVo = new LeaveVo();
            leaveVo.setReason("无请假记录");
            stuList.add(leaveVo);
        }
        if(teaList==null||teaList.size()<=0){
            teaList = new ArrayList<>();
            LeaveVo leaveVo = new LeaveVo();
            leaveVo.setReason("无请假记录");
            teaList.add(leaveVo);
        }
        model.addAttribute("countNum",countNum);
        model.addAttribute("longinVo",loginVo);
        model.addAttribute("stuNum",stuNum);
        model.addAttribute("teaNum",teaNum);
        model.addAttribute("stuList",stuList);
        model.addAttribute("teaList",teaList);
        model.addAttribute("countTodayNum",countTodayNum);
        return "manager/main";
    }
}
