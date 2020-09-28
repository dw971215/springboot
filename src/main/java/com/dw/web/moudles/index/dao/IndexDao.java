package com.dw.web.moudles.index.dao;

import com.dw.web.moudles.login.entity.LoginVo;
import com.dw.web.moudles.user.leavemanagement.entity.LeaveVo;
import com.dw.web.moudles.user.personer.entity.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IndexDao {
    /**
     * 获取登录人的信息
     * @param cardId
     * @return
     */
    LoginVo getLoginVo(String cardId);

    /**
     * 获取用户总量
     * @return
     */
    String getCount();

    String getTodayCount();

    /**
     * 获取学生请假总条数
     * @param cardId
     * @return
     */
    String getStuCount(String cardId);

    /**
     * 老师待审核请假数据
     * @param cardId
     * @return
     */
    String getTeaCount(String cardId);

    List<LeaveVo> getStuList(String cardId);

    List<LeaveVo> getTeaList(String cardId);

    List<LeaveVo> getStuWeekData(String cardId);

    List<UserVo> getTeaClassData(String cardId);
}
