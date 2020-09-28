package com.dw.web.moudles.user.leavemanagement.dao;

import com.dw.web.moudles.user.leavemanagement.entity.LeaveVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sun.security.timestamp.TSRequest;

import java.util.List;

@Mapper
@Repository
public interface LeaveManagementDao {

    /**
     * 获取所有的审核者
     * @return
     */
    List<LeaveVo> getApprover();

    /**
     * 保存请假信息
     * @param leaveVo
     * @return
     */
    int saveLeaveManager(LeaveVo leaveVo);

    /**
     * 获取个人的请假信息
     * @param leaveVo
     * @return
     */
    List<LeaveVo> getLeaveList(LeaveVo leaveVo);

    /**
     * 老师获取请假审核信息
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
     * 查询特定的请假人信息
     * @param leaveName
     * @return
     */
    List<LeaveVo> selectStu(String leaveName);
}
