package com.maxqh.biz.manager.manager.menu.auth.dataobject;

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
@Entity(name = "Auth")
@Table(name = "tb_auth")
public class AuthDO {
    /**
     * id
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 功能名称
     */
    @Column(name = "name", nullable = false)
    private String name;
    /**
     * 功能链接
     */
    @Column(name = "action", nullable = false)
    private String url;

    @Column(name = "sequence", nullable = false)
    private Integer sequence;

    @Column(name = "category", nullable = false)
    private String category;

    private Integer menu_id;

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

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

}
