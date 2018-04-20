package com.maxqh.biz.dal.menu.menu;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxqh.biz.manager.manager.menu.menu.dataobject.MenuDO;

/**
 * @Author:qianhao
 * @Description: 菜单DAO
 * @Date:2018/4/20
 * @Version:1.0
 */
public interface MenuDAO extends JpaRepository<MenuDO, String> {
}
