/*
 * @(#) AjaxResponseVo.java 2016年08月31日
 *
 * Copyright (c) 2016, SIMPO Technology. All Rights Reserved. SIMPO Technology. CONFIDENTIAL
 */
package com.dw.web.common.response;

import java.io.Serializable;


/**
 * 统一Ajax请求返回Vo
 *
 * @author 大卫
 * @version 1.0
 * @since 2019年11月12日
 */
public class AjaxResponseVo implements Serializable {
  private static final long serialVersionUID = -4822621162212802581L;

  public static final int CODE_FAILED = 20000;
  /* 编码：指示错误代码 */
  private int code;
  /* 错误信息：对应于code */
  private String msg;
  /* 返回结果 */
  private Object result;




  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Object getResult() {
    return result;
  }

  public void setResult(Serializable result) {
    this.result = result;
  }

  /**
   * 静态构造器
   *
   * @param responseCode 响应编码
   * @return 构造器对象
   */
  public static AjaxResponseVo of(ResponseCode responseCode) {
    AjaxResponseVo vo = new AjaxResponseVo();
    vo.code = responseCode.code();
    vo.msg = responseCode.message();
    return vo;
  }

  /**
   * 静态构造器
   *
   * @param result 返回结果
   * @return 构造器对象
   */
  public static AjaxResponseVo of(Object result) {
    AjaxResponseVo vo = new AjaxResponseVo();
    vo.result = result;
    vo.code = ResponseCode.SUCCESS.code();
    vo.msg = ResponseCode.SUCCESS.message();
    return vo;
  }

  public static AjaxResponseVo fail(String result) {
    AjaxResponseVo vo = new AjaxResponseVo();
    vo.result = "fail";
    vo.code = CODE_FAILED;
    vo.msg = result;
    return vo;
  }

  /**
   * 静态构造器
   *
   * @param result 返回结果
   * @param msg 返回消息
   * @return 构造器对象
   */
  public static AjaxResponseVo of(Object result, String msg) {
    AjaxResponseVo vo = new AjaxResponseVo();
    vo.result = result;
    vo.code = ResponseCode.SUCCESS.code();
    vo.msg = msg;
    return vo;
  }

  /**
   * 设定响应编码
   *
   * @param responseCode 响应编码
   * @return 构造器对象
   */
  public AjaxResponseVo code(ResponseCode responseCode) {
    this.code = responseCode.code();
    this.msg = responseCode.message();
    return this;
  }

  /**
   * 设定返回结果
   *
   * @param result 返回结果
   * @return 构造器对象
   */
  public AjaxResponseVo result(Object result) {
    this.result = result;
    return this;
  }

}
