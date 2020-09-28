package com.dw.web.moudles.user.leavemanagement.service;

import com.dw.web.moudles.user.leavemanagement.entity.LeaveVo;

import java.util.List;

public interface LeaveManagementService {
    /**
     * 获取所有的审核者
     * @return
     */
    List<LeaveVo> getApprover();

    int saveLeaveManager(LeaveVo leaveVo);

    /**
     * 学生请假记录
     * @param leaveVo
     * @return
     */
    List<LeaveVo> getLeaveList(LeaveVo leaveVo);

    /**
     * 老师请假审核页面
     * @param leaveVo
     * @return
     */
    List<LeaveVo> getLeaveManageList(LeaveVo leaveVo);

    /**
     * 老师审核记录
     * @param leaveVo
     * @return
     */
    List<LeaveVo> verifyRecord(LeaveVo leaveVo);

    /**
     * 审核通过
     * @param id
     * @return
     */
    int leavePass(String id);

    /**
     * 审核不通过
     * @param id
     * @return
     */
    int leaveNoPass(String id);

    /**
     * 查询特定请假人信息
     * @param leaveName
     * @return
     */
    List<LeaveVo> selectStu(String leaveName);

}
