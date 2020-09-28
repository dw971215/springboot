package com.dw.web.moudles.user.personer.service.impl;

import com.dw.web.moudles.user.personer.dao.UserDao;
import com.dw.web.moudles.user.personer.entity.UserVo;
import com.dw.web.moudles.user.personer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false,rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    /**
     * 修改个人信息
     * @param userVo
     * @return
     */
    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public int updatePersonInfo(UserVo userVo) {
        return userDao.updatePersonInfo(userVo);
    }

    /**
     * 获取个人信息
     * @param userVo
     * @return
     */
    @Override
    @Transactional(readOnly = true,rollbackFor = Exception.class)
    public UserVo getUserVo(UserVo userVo) {
        return userDao.getUserVo(userVo);
    }

    /**
     * 修改密码
     * @param userVo
     * @return
     */
    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public int updatePassWord(UserVo userVo) {
        return userDao.updatePassWord(userVo);
    }
}
