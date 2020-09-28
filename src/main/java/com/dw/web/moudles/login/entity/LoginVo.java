package com.dw.web.moudles.login.entity;

/**
 * 后台登录实体类
 *
 */
public class LoginVo {

    private String id;
    /**
     * 用户姓名
     */
    private String uname;
    /**
     * 用户密码
     */
    private String pwd;

    /**
     * 用户唯一识别码
     */
    private String cardId;

    /**
     * 所属身份
     */
    private String identity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
