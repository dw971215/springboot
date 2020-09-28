package com.dw.web.moudles.user.gatecard.service;

import com.dw.web.moudles.user.gatecard.entity.GateVo;

import java.util.List;

public interface GateCardService {

    public List<String> getGateCourse(GateVo gateVo);

    public List<GateVo> getGateCardMonth(GateVo gateVo);

    public List<GateVo> getTeaGateCardMonth(GateVo gateVo);
}
