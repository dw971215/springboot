package com.dw.web.moudles.user.personer.dao;

import com.dw.web.moudles.user.personer.entity.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
    /**
     * 修改个人信息
     * @param userVo
     * @return
     */
    int updatePersonInfo(UserVo userVo);

    /**
     * 查询个人资料
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
