package com.dw.web.moudles.user.leavemanagement.service.impl;

import com.dw.web.moudles.user.leavemanagement.dao.LeaveManagementDao;
import com.dw.web.moudles.user.leavemanagement.entity.LeaveVo;
import com.dw.web.moudles.user.leavemanagement.service.LeaveManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LeaveManagementServiceImpl implements LeaveManagementService {

    @Autowired
    private LeaveManagementDao leaveManagementDao;
    /**
     * 获取所有的审核者
     * @return
     */
    @Override
    public List<LeaveVo> getApprover() {
        return leaveManagementDao.getApprover();
    }

    /**
     * 保存请假信息
     * @param leaveVo
     * @return
     */
    @Override
    public int saveLeaveManager(LeaveVo leaveVo) {
        return leaveManagementDao.saveLeaveManager(leaveVo);
    }

    /**
     * 获取个人请假信息
     * @param leaveVo
     * @return
     */
    @Override
    public List<LeaveVo> getLeaveList(LeaveVo leaveVo) {
        return leaveManagementDao.getLeaveList(leaveVo);
    }

    /**
     * 老师 请假审核信息
     * @param leaveVo
     * @return
     */
    @Override
    public List<LeaveVo> getLeaveManageList(LeaveVo leaveVo) {
        return leaveManagementDao.getLeaveManageList(leaveVo);
    }

    @Override
    public List<LeaveVo> verifyRecord(LeaveVo leaveVo) {
        return leaveManagementDao.verifyRecord(leaveVo);
    }

    /**
     * 审核通过
     * @param id
     * @return
     */
    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public int leavePass(String id) {
        return leaveManagementDao.leavePass(id);
    }

    /**
     * 审核不通过
     * @param id
     * @return
     */
    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public int leaveNoPass(String id) {
        return leaveManagementDao.leaveNoPass(id);
    }

    @Override
    public List<LeaveVo> selectStu(String leaveName) {
        return leaveManagementDao.selectStu(leaveName);
    }
}
