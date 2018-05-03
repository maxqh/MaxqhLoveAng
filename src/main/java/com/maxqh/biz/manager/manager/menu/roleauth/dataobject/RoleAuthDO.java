package com.maxqh.biz.manager.manager.menu.roleauth.dataobject;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/4/20
 * @Version:1.0
 */
@Entity(name = "RoleAuth")
@Table(name = "tb_role_auth")
public class RoleAuthDO implements Serializable{
    /**
     * id
     */
    @Id
    @GeneratedValue
    private Integer role_id;

    @Id
    private Integer auth_id;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(Integer auth_id) {
        this.auth_id = auth_id;
    }

    /* @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_auth", joinColumns = {
            @JoinColumn(name = "auth_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "menu_id", referencedColumnName = "id") })
    private List<AuthDO> authEntities;

    public List<AuthDO> getAuthEntities() {
        return authEntities;
    }

    public void setAuthEntities(List<AuthDO> authEntities) {
        this.authEntities = authEntities;
    }*/
}
