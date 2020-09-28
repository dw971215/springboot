package com.dw.web.moudles.user.leavemanagement.controller;

import com.dw.web.moudles.index.service.IndexService;
import com.dw.web.moudles.user.leavemanagement.entity.LeaveVo;
import com.dw.web.moudles.user.leavemanagement.service.LeaveManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *请假管理模块
 */
@Controller
@RequestMapping("/pt/leave")
public class ViewLeaveManagementController {

    @Autowired
    private LeaveManagementService leaveManagementService;

    @Autowired
    private IndexService indexService;

    /**
     * 学生请假申请页面
     * @param cardId
     * @param model
     * @return
     */
    @RequestMapping(value = "/viewLeaveManagement")
    public String viewLeaveManagement(String cardId, Model model){
        model.addAttribute("cardId",cardId);
        String uname = indexService.getLoginVo(cardId).getUname();
        model.addAttribute("uname",uname);
        List<LeaveVo> list = leaveManagementService.getApprover();//获取所有审核者
        model.addAttribute("list",list);
        return "manager/newsAdd";
    }

    /**
     * 学生请假记录
     * @return
     */
   @RequestMapping(value = "/leaveRecord")
    public  String leaveRecord(LeaveVo leaveVo, Model model){
       model.addAttribute("cardId",leaveVo.getCardId());
       model.addAttribute("RecordTime",leaveVo.getRecorTime());
       /**
        * 获取请假信息
        */
       if(leaveVo.getRecorTime()==null || leaveVo.getRecorTime()==""){
           /**
            * 获取当天时间
            */
           /*Date date = new Date();
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           String today= dateFormat.format(date);
           leaveVo.setRecorStarTime(today+" 00:00:00");
           leaveVo.setRecorEndTime(today+" 23:59:59");*/
       }else{
           leaveVo.setRecorStarTime(leaveVo.getRecorTime()+" 00:00:00");
           leaveVo.setRecorEndTime(leaveVo.getRecorTime()+" 23:59:59");
       }
       List<LeaveVo> list = leaveManagementService.getLeaveList(leaveVo);
       model.addAttribute("list",list);
       return "manager/leaverecord";
    }


    /**
     * 老师请假审核
     * @param leaveVo
     * @param model
     * @return
     */
    @RequestMapping(value = "/leaveManage")
    public  String leaveManage(LeaveVo leaveVo, Model model){
        model.addAttribute("cardId",leaveVo.getCardId());
        model.addAttribute("leaveName",leaveVo.getLeaveName());
        /**
         * 获取请假信息
         */
        List<LeaveVo> list = leaveManagementService.getLeaveManageList(leaveVo);
        model.addAttribute("list",list);
        return "manager/leaveManage";
    }

    /**
     * 老师审核记录
     * @return
     */
    @RequestMapping(value = "/verifyRecord")
    public String verifyRecord(LeaveVo leaveVo,Model model){
        model.addAttribute("cardId",leaveVo.getCardId());
        model.addAttribute("leaveName",leaveVo.getLeaveName());
        model.addAttribute("recordTime",leaveVo.getRecorTime());
        if(leaveVo.getRecorTime()==null || leaveVo.getRecorTime()==""){
        }else{
            leaveVo.setRecorStarTime(leaveVo.getRecorTime()+" 00:00:00");
            leaveVo.setRecorEndTime(leaveVo.getRecorTime()+" 23:59:59");
        }

       List<LeaveVo> list =  leaveManagementService.verifyRecord(leaveVo);
        model.addAttribute("list",list);
        return "manager/verifyLeave";
    }

}
