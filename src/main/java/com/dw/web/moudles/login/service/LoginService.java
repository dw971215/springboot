package com.dw.web.moudles.login.service;

import com.dw.web.moudles.login.entity.LoginVo;

public interface LoginService {

    /**
     *登录检测
     * @param loginVo
     * @return
     */
    LoginVo getLoginVo(LoginVo loginVo);

    /**
     * 保存注册信息
     * @param loginVo
     * @return
     */
    int saveRegister(LoginVo loginVo);

}
