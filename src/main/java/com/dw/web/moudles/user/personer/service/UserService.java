package com.dw.web.moudles.user.personer.service;

import com.dw.web.moudles.user.personer.entity.UserVo;


public interface UserService {

    /**
     * 修改个人信息
     * @param userVo
     * @return
     */
    int updatePersonInfo(UserVo userVo);

    /**
     * 获取个人信息
     * @param userVo
     * @return
     */
    UserVo getUserVo(UserVo userVo);

    /**
     * 修改密码
     * @param userVo
     * @return
     */
    int updatePassWord(UserVo userVo);
}
