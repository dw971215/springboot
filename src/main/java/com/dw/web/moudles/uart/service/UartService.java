package com.dw.web.moudles.uart.service;

import com.dw.web.moudles.uart.entity.UartVo;

/**
 * 串口通信服务接口层
 */
public interface UartService {

    public  int add(UartVo uartVo);
    public UartVo selectOne(String stuCardId);
    public  int updateOne(int id);
    public  UartVo selectEndTime(String stuCardId);
}
