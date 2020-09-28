package com.dw.web.moudles.user.personer.entity;

/**
 * 用户个人信息
 */
public class UserVo {

    /**
     * id
     */
    private String id;
    /**
     * 真是姓名
     */
    private String uname;
    /**
     * 登录密码
     */
    private String pwd;
    /**
     * 账号
     */
    private  String cardId;
    /**
     * 所属身份（0 学生 1 教师）
     */
    private String  identity;
    /**
     * 手机号码
     */
    private String phone;

    /**
     * 所在班级
     */
    private String classInfo;

    /**
     * 座右铭
     */
    private String motto;

    /**
     * 性别
     */
    private String sex;

    /**
     * 班级人数
     */
    private String counts;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }
}
