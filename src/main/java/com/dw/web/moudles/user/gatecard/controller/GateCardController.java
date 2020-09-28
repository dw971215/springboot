package com.dw.web.moudles.user.gatecard.controller;

import com.dw.web.common.response.AjaxResponseVo;
import com.dw.web.moudles.user.gatecard.entity.GateVo;
import com.dw.web.moudles.user.gatecard.service.GateCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 出勤统计表视图
 */
@Controller
@RequestMapping(value = "/pt/gateCard")
public class GateCardController {

    @Autowired
    private GateCardService gateCardService;


    /**
     * 学生当天的考勤科目
     * @param gateVo
     * @return
     */
    @RequestMapping(value = "/getGateCard")
    @ResponseBody
    public AjaxResponseVo getGateCard(GateVo gateVo){
        if(gateVo.getGateTime()==null || gateVo.getGateTime()==""){
            /**
             * 获取当天时间
             */

            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String today= dateFormat.format(date);
            gateVo.setStarTime(today+" 00:00:00");
            gateVo.setEndTime(today+" 23:59:59");
        }else{
            gateVo.setStarTime(gateVo.getGateTime()+" 00:00:00");
            gateVo.setEndTime(gateVo.getGateTime()+" 23:59:59");
        }
       List<String> list =  gateCardService.getGateCourse(gateVo);
        if(list.size()==0){
            list.add("未上课");
        }
        return AjaxResponseVo.of(list);
    }

    /**
     * 学生当月的考勤数据
     * @param gateVo
     * @return
     */
    @RequestMapping(value = "/getGateCardMonth")
    @ResponseBody
    public AjaxResponseVo getGateCardMonth(GateVo gateVo){

        if(gateVo.getGateMonth()==null || gateVo.getGateMonth()==""){
            /**
             * 获取当天时间
             */
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           String today= dateFormat.format(date);
            gateVo.setGateMonth(today);
        }else{
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
            String today= dateFormat.format(date);
            gateVo.setGateMonth(today+"-"+gateVo.getGateMonth()+"-01");
        }

       List<GateVo> list =  gateCardService.getGateCardMonth(gateVo);
        if(list.size()==0){
            GateVo gateVo1 = new GateVo();
            gateVo1.setCourseName("本月未上课");
            gateVo1.setCounts("1");
            list.add(gateVo1);
        }
        return AjaxResponseVo.of(list);
    }


    /**
     * 教師考勤统计
     * @param gateVo
     * @return
     */
    @RequestMapping(value = "/getTeaGateCard")
    @ResponseBody
    public AjaxResponseVo getTeaGateCardMonth(GateVo gateVo){

        if(gateVo.getGateTime()==null || gateVo.getGateTime()==""){
            /**
             * 获取当天时间
             */
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String today= dateFormat.format(date);
            gateVo.setStarTime(today+" 00:00:00");
            gateVo.setEndTime(today+" 23:59:59");
        }else{
            gateVo.setStarTime(gateVo.getGateTime()+" 00:00:00");
            gateVo.setEndTime(gateVo.getGateTime()+" 23:59:59");
        }

        List<GateVo> list =  gateCardService.getTeaGateCardMonth(gateVo);
        if(list.size()==0){
            GateVo gateVo1 = new GateVo();
            gateVo1.setCourseName("今天未上课");
            gateVo1.setCounts("1");
            list.add(gateVo1);
        }
        return AjaxResponseVo.of(list);
    }
}
