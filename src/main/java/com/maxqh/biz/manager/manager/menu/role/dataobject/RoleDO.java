package com.maxqh.biz.manager.manager.menu.role.dataobject;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.maxqh.biz.manager.manager.menu.menu.dataobject.MenuDO;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/4/20
 * @Version:1.0
 */
@Entity(name = "Role")
@Table(name = "tb_role")
public class RoleDO {
    /**
     * id
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 角色名称
     */
    @Column(name = "name", nullable = false)
    private String name;
    /**
     * 用户类型
     */
    @Column(name = "label", nullable = false)
    private String label;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_role_menu", joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "menu_id", referencedColumnName = "id") })
    private Set<MenuDO> menus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<MenuDO> getMenus() {
        return menus;
    }

    public void setMenus(Set<MenuDO> menus) {
        this.menus = menus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLable() {
        return label;
    }

    public void setLable(String label) {
        this.label = label;
    }
}
