package com.dw.web.moudles.uart.dao;

import com.dw.web.moudles.uart.entity.UartVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 串口通信dao层
 */
@Repository
@Mapper
public interface UartDao {

    public int add(UartVo uartVo);

    public UartVo selectOne(String stuCardId);

    public int updateOne(int id);

    public UartVo selectEndTime(String stuCardId);

}
