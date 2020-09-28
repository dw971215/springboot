package com.dw.web.moudles.user.gatecard.service.Impl;

import com.dw.web.moudles.user.gatecard.dao.GateCardDao;
import com.dw.web.moudles.user.gatecard.entity.GateVo;
import com.dw.web.moudles.user.gatecard.service.GateCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GateCardServiceImpl implements GateCardService {

    @Autowired
    private GateCardDao gateCardDao;

    @Override
    public List<String> getGateCourse(GateVo gateVo) {
        return gateCardDao.getGateCourse(gateVo);
    }

    @Override
    public List<GateVo> getGateCardMonth(GateVo gateVo) {
        return gateCardDao.getGateCardMonth(gateVo);
    }

    @Override
    public List<GateVo> getTeaGateCardMonth(GateVo gateVo) {
        return  gateCardDao.getTeaGateCardMonth(gateVo);
    }
}
