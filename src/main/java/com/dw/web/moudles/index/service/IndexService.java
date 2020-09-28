package com.dw.web.moudles.index.service;

import com.dw.web.moudles.login.entity.LoginVo;
import com.dw.web.moudles.user.leavemanagement.entity.LeaveVo;
import com.dw.web.moudles.user.personer.entity.UserVo;

import java.util.List;

public interface IndexService {
    LoginVo getLoginVo(String cardId);
    /**
     * 获取用户总量数据
     */
    String getCount();

    String getTodayCount();

    String getStuCount(String cardId);
    String getTeaCount(String cardId);

    List<LeaveVo> getStuList(String cardId);
    List<LeaveVo> getTeaList(String cardId);

    /**
     * 获取学生首页数据
     * @param cardId
     * @return
     */
    List<LeaveVo> getStuWeekData(String cardId);

    /**
     * 老师获取学生班级信息
     * @param cardId
     * @return
     */
    List<UserVo> getTeaClassData(String cardId);


}
