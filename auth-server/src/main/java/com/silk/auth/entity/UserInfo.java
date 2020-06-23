package com.silk.auth.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(UserInfo)实体类
 *
 * @author makejava
 * @since 2019-08-13 14:06:22
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -96498540825138267L;

    private static final Short STATUS_FROZEN = 1;

    private Integer id;
    //昵称
    private String nickname;
    //用户名
    private String username;
    //密码
    private String password;
    //电话
    private String phone;
    //邮箱
    private String email;
    //地址
    private String address;
    //是否管理员。0否1是
    private Short adminFlag;
    //状态。0正常，1冻结
    private Short status;
    //是否删除。0否1是
    private Short deleteFlag;
    //注册时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //修改人ID
    private String updateNo;
    //修改人用户名
    private String updateName;
    //最后登录时间
    private Date lastTime;

    private String lastIp;

    /**
     * 账号是否冻结
     *
     * @return
     */
    public boolean isFrozen() {
        return STATUS_FROZEN.equals(this.status);
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Short getAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(Short adminFlag) {
        this.adminFlag = adminFlag;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateNo() {
        return updateNo;
    }

    public void setUpdateNo(String updateNo) {
        this.updateNo = updateNo;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

}