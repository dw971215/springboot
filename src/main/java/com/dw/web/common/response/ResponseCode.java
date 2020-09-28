/*
 * @(#) ResponseCode.java 2019年11月12日
 *
 * Copyright (c) 2019, SIMPO Technology. All Rights Reserved. SIMPO Technology. CONFIDENTIAL
 */
package com.dw.web.common.response;

/**
 * 响应代码 Enum
 * <p>
 * 10000 -默认成功信息 20000-默认失败信息
 * </p>
 * <p>
 * 小于10000用于定义共通信息； 10000-19999用于定义 提示（info）、警告（warning）信息； 20001以上用于定义 错误（error）信息。
 * </p>
 *
 * @author 大卫
 * @version 1.0
 * @since 2019年11月12日
 */
public enum ResponseCode {
  /* 默认成功信息 */
  SUCCESS(10000, "处理成功"),


  /* 默认失败信息 */
  FAIL(20000, "处理失败"),
  UNAUTHORIZED(401,"抱歉，操作权限不足"),
  MAX_UPLOAD_SIZE_EXCEEDED(460, "抱歉，文件大小超过限制"),

  /* 保存成功信息 */
  SAVE_SUCCESS(10000,"保存成功"),
  /* 保存失败信息 */
  SAVE_FAIL(20000,"保存失败"),

  /* 删除成功信息 */
  DEL_SUCCESS(10000,"删除成功"),
  /* 删除失败信息 */
  DEL_FAIL(20000,"删除失败");




  private int code;
  private String message;

  ResponseCode(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int code() {
    return code;
  }

  public String message() {
    return message;
  }
}
