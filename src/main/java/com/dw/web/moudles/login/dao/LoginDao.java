package com.dw.web.moudles.login.dao;

import com.dw.web.moudles.login.entity.LoginVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoginDao {

    /**
     * 登录检测
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
