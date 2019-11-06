package com.maxqh.biz.manager.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.maxqh.biz.manager.manager.menu.menu.dataobject.MenuDO;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/4/22
 * @Version:1.0
 */
public class DeepCopyUtils {
    /**
     * 深拷贝
     *
     * @param src
     * @param <T>
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<MenuDO> sourceList = new ArrayList<>();
        MenuDO menuA = new MenuDO();
        menuA.setId(1);
        sourceList.add(menuA);
        sourceList.add(menuA);
        sourceList.add(menuA);

        List<MenuDO> copyList = deepCopy(sourceList);
        sourceList.get(0).setId(2222);
        sourceList.get(1).setId(2222);
        sourceList.get(2).setId(2222);

        System.out.println(copyList.get(0).getId());
        System.out.println(sourceList.get(0).getId());
    }
}
