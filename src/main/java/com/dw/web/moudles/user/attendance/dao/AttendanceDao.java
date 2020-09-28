package com.dw.web.moudles.user.attendance.dao;

import com.dw.web.moudles.user.attendance.entity.AttendanceVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AttendanceDao {
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
     * 单条出勤信息
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
     * 老师获取考勤学生列表
     * @param attendanceVo
     * @return
     */
    List<AttendanceVo> teaViewRecord(AttendanceVo attendanceVo);

    /**
     * 老师查看学生考勤记录列表
     * @param attendanceVo
     * @return
     */
    List<AttendanceVo> getTeaAttendanceRecordList(AttendanceVo attendanceVo);


}
