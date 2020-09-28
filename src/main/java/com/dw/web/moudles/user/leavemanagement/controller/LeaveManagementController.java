package com.dw.web.moudles.user.leavemanagement.controller;

import com.dw.web.common.response.AjaxResponseVo;
import com.dw.web.moudles.user.leavemanagement.entity.LeaveVo;
import com.dw.web.moudles.user.leavemanagement.service.LeaveManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *请假管理模块
 */
@Controller
@RequestMapping("/pt/leave")
public class LeaveManagementController {

    @Autowired
    private LeaveManagementService leaveManagementService;

    /**
     * 保存学生请假信息
     * @param leaveVo
     * @return
     */
    @RequestMapping(value = "/saveLeaveManager")
    @ResponseBody
    public AjaxResponseVo saveLeaveManager(@RequestBody LeaveVo leaveVo){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            leaveVo.setStartTime(sf.parse(leaveVo.getStuStarTime()));
            leaveVo.setEndTime(sf.parse(leaveVo.getStuEndTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int a = leaveManagementService.saveLeaveManager(leaveVo);
        if(a>0){
            return AjaxResponseVo.of("申请成功");
        }else{
            return  AjaxResponseVo.fail("申请失败");
        }

    }

    /**
     *审核通过
     * @return
     */
    @RequestMapping(value = "/leavePass")
    @ResponseBody
    public  AjaxResponseVo leavePass(String id){
      int a = leaveManagementService.leavePass(id);
      if(a>0){
          return  AjaxResponseVo.of("审核成功");
      }else{
          return AjaxResponseVo.fail("审核失败");
      }
    }

    /**
     *审核不通过
     * @return
     */
    @RequestMapping(value = "/leaveNoPass")
    @ResponseBody
    public  AjaxResponseVo leaveNoPass(String id){

        int a = leaveManagementService.leaveNoPass(id);
        if(a>0){
            return  AjaxResponseVo.of("审核成功");
        }else{
            return AjaxResponseVo.fail("审核失败");
        }

    }

    @RequestMapping(value = "/selectStu")
    @ResponseBody
    public AjaxResponseVo selectStu(String leaveName){
        List<LeaveVo> list = leaveManagementService.selectStu(leaveName);
        return  AjaxResponseVo.of(list);
    }
}
