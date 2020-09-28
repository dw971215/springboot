package com.dw.web.moudles.user.attendance.controller;

import com.dw.web.common.response.AjaxResponseVo;
import com.dw.web.moudles.user.attendance.entity.AttendanceVo;
import com.dw.web.moudles.user.attendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 出勤管理
 */
@Controller
@RequestMapping("/pt/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    /**
     * 保存出勤信息
     * @return
     */
    @RequestMapping(value = "saveAttendance")
    @ResponseBody
    public AjaxResponseVo saveAttendance(@RequestBody AttendanceVo attendanceVo){
        if(!"".equals(attendanceVo.getContent()) && attendanceVo.getContent()!=null){
                attendanceVo.setEditStatus("1");
        }else{
            attendanceVo.setEditStatus("0");
        }
        int a = attendanceService.saveAttendance(attendanceVo);
        if(a>0){
            return AjaxResponseVo.of("保存成功");
        }else{
            return AjaxResponseVo.fail("保存失败");
        }

    }
}
