package com.maxqh.biz.manager.enums;

/**
 * @Author:qianhao
 * @Description: 用户状态枚举类
 * @Date:2018/4/20
 * @Version:1.0
 */
public enum EnumUserStatus {
    STOPPING("2", "禁用", "禁用"), NORMAL("1", "正常", "正常"), DELETE("0", "删除", "删除");

    private String key;
    private String value;
    private String des;

    EnumUserStatus(String key, String value, String des) {
        this.key = key;
        this.value = value;
        this.des = des;
    }

    /**
     * 根据用户状态返回枚举类
     *
     * @param status
     * @return
     */
    public EnumUserStatus getEnumByKey(Integer status){
        if(status == null){
            return null;
        }

        //遍历枚举类
        for(EnumUserStatus userStatusEnum: EnumUserStatus.values()){
            if(userStatusEnum.getKey().equalsIgnoreCase(status.toString())){
                return userStatusEnum;
            }
        }

        return null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
