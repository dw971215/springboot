package com.dw.web.moudles.login.service.impl;

import com.dw.web.moudles.login.dao.LoginDao;
import com.dw.web.moudles.login.entity.LoginVo;
import com.dw.web.moudles.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    /**
     * 登录检测
     * @param loginVo
     * @return
     */
    @Override
    public LoginVo getLoginVo(LoginVo loginVo) {
        return loginDao.getLoginVo(loginVo);
    }

    /**
     * 保存注册信息
     * @param loginVo
     * @return
     */
    @Override
    public int saveRegister(LoginVo loginVo) {
        return loginDao.saveRegister(loginVo);
    }
}
