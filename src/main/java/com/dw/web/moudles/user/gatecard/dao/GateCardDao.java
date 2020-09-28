package com.dw.web.moudles.user.gatecard.dao;

import com.dw.web.moudles.user.gatecard.entity.GateVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GateCardDao {

    public List<String> getGateCourse(GateVo gateVo);

    public List<GateVo> getGateCardMonth(GateVo gateVo);

    public List<GateVo> getTeaGateCardMonth(GateVo gateVo);
}
