package com.dw.web.moudles.index.service.impl;

import com.dw.web.moudles.index.dao.IndexDao;
import com.dw.web.moudles.index.service.IndexService;
import com.dw.web.moudles.login.entity.LoginVo;
import com.dw.web.moudles.user.leavemanagement.entity.LeaveVo;
import com.dw.web.moudles.user.personer.entity.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    /**
     * 获取登录人的信息
     * @param cardId
     * @return
     */
    @Autowired
    private IndexDao indexDao;
    @Override
    public LoginVo getLoginVo(String cardId) {
        return indexDao.getLoginVo(cardId);
    }

    @Override
    public String getCount() {
        return indexDao.getCount();
    }

    @Override
    public String getTodayCount() {
        return indexDao.getTodayCount();
    }

    @Override
    public String getStuCount(String cardId) {
        return indexDao.getStuCount(cardId);
    }

    @Override
    public String getTeaCount(String cardId) {
        return indexDao.getTeaCount(cardId);
    }

    @Override
    public List<LeaveVo> getStuList(String cardId) {
        return indexDao.getStuList(cardId);
    }

    @Override
    public List<LeaveVo> getTeaList(String cardId) {
        return indexDao.getTeaList(cardId);
    }

    @Override
    public List<LeaveVo> getStuWeekData(String cardId) {
        return indexDao.getStuWeekData(cardId);
    }

    @Override
    public List<UserVo> getTeaClassData(String cardId) {
        return indexDao.getTeaClassData(cardId);
    }
}
