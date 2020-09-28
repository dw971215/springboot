package com.dw.web.moudles.user.attendance.service.Impl;

import com.dw.web.moudles.user.attendance.dao.AttendanceDao;
import com.dw.web.moudles.user.attendance.entity.AttendanceVo;
import com.dw.web.moudles.user.attendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 出勤管理
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {


    @Autowired
    private AttendanceDao attendanceDao;
    /**
     *出勤编辑
     * @param attendanceVo
     * @return
     */
    @Override
    public List<AttendanceVo> getAttendanceList(AttendanceVo attendanceVo) {
        return attendanceDao.getAttendanceList(attendanceVo);
    }

    /**
     * 出勤记录
     * @param attendanceVo
     * @return
     */
    @Override
    public List<AttendanceVo> getAttendanceRecordList(AttendanceVo attendanceVo) {
        return attendanceDao.getAttendanceRecordList(attendanceVo);
    }

    /**
     * 单条出勤详情
     * @param id
     * @return
     */
    @Override
    public AttendanceVo getOneAttendanceDetail(String id) {
        return attendanceDao.getOneAttendanceDetail(id);
    }

    /**
     * 保存出勤信息
     * @param attendanceVo
     * @return
     */
    @Override
    public int saveAttendance(AttendanceVo attendanceVo) {
        return attendanceDao.saveAttendance(attendanceVo);
    }

    /**
     * 老师查看学生考勤列表
     * @param attendanceVo
     * @return
     */
    @Override
    public List<AttendanceVo> teaViewRecord(AttendanceVo attendanceVo) {
        return attendanceDao.teaViewRecord(attendanceVo);
    }

    @Override
    public List<AttendanceVo> getTeaAttendanceRecordList(AttendanceVo attendanceVo) {
        return attendanceDao.getTeaAttendanceRecordList(attendanceVo);
    }
}
