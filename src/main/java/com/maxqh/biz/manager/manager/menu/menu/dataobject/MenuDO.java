package com.maxqh.biz.manager.manager.menu.menu.dataobject;

import javax.persistence.Column;
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
@Entity(name = "Menu")
@Table(name = "tb_admin_menu")
public class MenuDO {
    /**
     * id
     */
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * 菜单名称
     */
    @Column(name = "name", nullable = false)
    private String name;
    /**
     * 菜单链接
     */
    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "sequence", nullable = false)
    private Integer sequence;

    @Column(name = "parent_id", nullable = true)
    private Integer parentId;

    // @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    //
    // @JoinColumn(name = "id", nullable = false)
    // private List<AuthEntity> authEntities;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}
