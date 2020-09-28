package com.dw.web.moudles.uart.service.Impl;

import com.dw.web.moudles.uart.dao.UartDao;
import com.dw.web.moudles.uart.entity.UartVo;
import com.dw.web.moudles.uart.service.UartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 串口通信服务层
 */
@Service
public class UartServiceImpl implements UartService {

    @Autowired
    private UartDao uartDao;

    @Override
    public int add(UartVo uartVo) {
        return  uartDao.add(uartVo);
    }

    /**
     * 插入之前查询有没有打卡
     * @param stuCardId
     * @return
     */
    @Override
    public UartVo selectOne(String stuCardId) {
        return uartDao.selectOne(stuCardId);
    }

    @Override
    public int updateOne(int id) {
        return uartDao.updateOne(id);
    }

    @Override
    public UartVo selectEndTime(String stuCardId) {
        return uartDao.selectEndTime(stuCardId);
    }
}
