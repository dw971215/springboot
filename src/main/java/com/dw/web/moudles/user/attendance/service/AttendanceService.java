package com.dw.web.moudles.user.attendance.service;

import com.dw.web.moudles.user.attendance.entity.AttendanceVo;

import java.util.List;

/**
 * 出勤管理
 */
public interface AttendanceService {

    /**
     * 出勤编辑
     * @param attendanceVo
     * @return
     */
    List<AttendanceVo> getAttendanceList(AttendanceVo attendanceVo);

    /**
     * 出勤记录
     * @param attendanceVo
     * @return
     */
    List<AttendanceVo> getAttendanceRecordList(AttendanceVo attendanceVo);

    /**
     * 获取单个出勤信息
     * @param id
     * @return
     */
    AttendanceVo getOneAttendanceDetail(String id);


    /**
     * 保存出勤信息
     * @param attendanceVo
     * @return
     */
    int saveAttendance(AttendanceVo attendanceVo);

    /**
     * 老师查看学生考勤列表
     * @param attendanceVo
     * @return
     */
    List<AttendanceVo> teaViewRecord(AttendanceVo attendanceVo);

    /**
     * 老师查看学生的考勤记录
     * @return
     */
    List<AttendanceVo> getTeaAttendanceRecordList(AttendanceVo attendanceVo);


}
