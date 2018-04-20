package com.maxqh.biz.dal.menu;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/4/20
 * @Version:1.0
 */

@Entity(name = "User")
@Table(name = "tb_user_basic")
public class UserDO {
    /**
     * id
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 用户名称
     */
    @Column(name = "user_name", nullable = false)
    private String loginName;
    /**
     * 用户名称
     */
    @Column(name = "real_name", nullable = false)
    private String name;
    /**
     * 密码
     */
    @Column(name = "password", nullable = false)
    private String password;
    /**
     * 角色
     */
    // @Column(name = "role_id",nullable = false)
    // private Integer role_id;

    /**
     * 状态
     */
    @Column(name = "status", nullable = false)
    private Integer status;

    /**
     * 最后登录时间
     */
    @Column(name = "last_login_time", nullable = false)
    private Date last_login_time;

    private Date create_time;

    // @Enumerated(EnumType.ORDINAL)
    // @Column(name = "status",nullable = false)
    // private UserStatus status;

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name = "role_id")
    private RoleDO role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public RoleDO getRole() {
        return role;
    }

    public void setRole(RoleDO role) {
        this.role = role;
    }
    // public UserStatus getStatus() {
    // return status;
    // }
    // public void setStatus(UserStatus status) {
    // this.status = status;
    // }

    /*
     * public Integer getRole_id() { return role_id; } public void
     * setRole_id(Integer role_id) { this.role_id = role_id; }
     */
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }
}
