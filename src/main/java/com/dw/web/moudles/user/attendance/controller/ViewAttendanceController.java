package com.dw.web.moudles.user.attendance.controller;

import com.dw.web.moudles.user.attendance.entity.AttendanceVo;
import com.dw.web.moudles.user.attendance.service.AttendanceService;
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
 *出勤管理模块
 */
@Controller
@RequestMapping("/pt/attendance")
public class ViewAttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private LeaveManagementService leaveManagementService;

    public final static String ZERO = "0";

    /**
     * 学生出勤记录视图
     * @param attendanceVo
     * @param model
     * @return
     */
    @RequestMapping(value = "/viewAttendance")
    public String viewAttendance(AttendanceVo attendanceVo,Model model){
        model.addAttribute("cardId",attendanceVo.getCardId());
        model.addAttribute("RecordTime",attendanceVo.getRecorTime());
        /**
         * 获取请假信息
         */
        if(attendanceVo.getRecorTime()==null || attendanceVo.getRecorTime()==""){
        }else{
            attendanceVo.setRecordStarTime(attendanceVo.getRecorTime()+" 00:00:00");
            attendanceVo.setRecordEndTime(attendanceVo.getRecorTime()+" 23:59:59");
        }

        List<AttendanceVo> list = attendanceService.getAttendanceRecordList(attendanceVo);
        model.addAttribute("list",list);
        return  "manager/attendance";
    }

    /**
     * 学生出勤编辑列表
     * @return
     */
    @RequestMapping(value = "/viewAttendanceEdit")
    public  String viewAttendanceEdit(AttendanceVo attendanceVo,Model model){
        model.addAttribute("cardId",attendanceVo.getCardId());
        model.addAttribute("recordTime",attendanceVo.getRecorTime());
        model.addAttribute("editStatus",attendanceVo.getEditStatus());
        /**
         * 获取请假信息
         */
        if(attendanceVo.getRecorTime()==null || attendanceVo.getRecorTime()==""){
        }else{
            attendanceVo.setRecordStarTime(attendanceVo.getRecorTime()+" 00:00:00");
            attendanceVo.setRecordEndTime(attendanceVo.getRecorTime()+" 23:59:59");
        }
        if(attendanceVo.getEditStatus()==null || "".equals(attendanceVo.getEditStatus())){
            attendanceVo.setEditStatus("0");
        }
        List<AttendanceVo> list = attendanceService.getAttendanceList(attendanceVo);
        model.addAttribute("list",list);
        return  "manager/attendanceEdit";
    }

    /**
     * 学生编辑出勤信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/viewAttendanceDetail")
    public String viewAttendanceDetail(String id,String flag,Model model){
        List<LeaveVo> list = leaveManagementService.getApprover();//获取所有审核者
        model.addAttribute("list",list);
        if(flag!=null){
            model.addAttribute("flag",flag);
        }
       AttendanceVo attendanceVo = attendanceService.getOneAttendanceDetail(id);
       model.addAttribute("attendanceVo",attendanceVo);
       return "manager/attendanceDeatil";
    }

    /**
     * 老师查看学生出勤记录
     * @param attendanceVo
     * @param model
     * @return
     */
    @RequestMapping(value = "teaViewRecord")
    public String teaViewRecord(AttendanceVo attendanceVo,Model model){

        if((attendanceVo.getRecordStarTime()==null || attendanceVo.getRecordStarTime()=="")&&(attendanceVo.getRecordEndTime()==null||attendanceVo.getRecordEndTime()=="")){
           Date date = new Date();
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           String today= dateFormat.format(date);
           attendanceVo.setRecordStarTime(today+" 00:00:00");
           attendanceVo.setRecordEndTime(today+" 23:59:59");
        }

        List<AttendanceVo> list  = attendanceService.teaViewRecord(attendanceVo);
        int size = 0;
        if(list!=null){
            size = list.size();
        }
        list.stream().forEach(iteam->{
            if(ZERO.equals(iteam.getIdentity())){
                iteam.setIdentity("男");
            }else {
                iteam.setIdentity("女");
            }
        });
        model.addAttribute("list",list);
        model.addAttribute("size",size);
        model.addAttribute("teaCardId",attendanceVo.getCardId());
        model.addAttribute("leaveName",attendanceVo.getLeaveName());
        model.addAttribute("recorStarTime",attendanceVo.getRecordStarTime());
        model.addAttribute("recorEndTime",attendanceVo.getRecordEndTime());
        return "manager/teaAttendanceRecordList";
    }


    /**
     * 老师查看学生的出勤记录视图
     * @param attendanceVo
     * @param model
     * @return
     */
    @RequestMapping(value = "/teaViewAttendance")
    public String teaViewAttendance(AttendanceVo attendanceVo,Model model){
        model.addAttribute("stuCardId",attendanceVo.getStuCardId());
        model.addAttribute("recorStarTime",attendanceVo.getRecordStarTime());
        model.addAttribute("recorEndTime",attendanceVo.getRecordEndTime());
        List<AttendanceVo> list = attendanceService.getTeaAttendanceRecordList(attendanceVo);
        model.addAttribute("list",list);
        return  "manager/teaAttendance";
    }

}
