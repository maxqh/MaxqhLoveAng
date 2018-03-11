package com.maxqh.biz.manager.enums;

/**
 * @Author:qianhao
 * @Description: 纪念日枚举类
 * @Date:2018/3/11
 * @Version:1.0
 */
public enum EnumAnniversaries {
    MOM_BIRTHDAY("MOM_BIRTHDAY", "19950109", "猪猪妈妈生日"),

    DAD_BIRTHDAY("DAD_BIRTHDAY", "19920405", "帅豪爸爸生日"),

    MOM_DAD_GETTING_TOGETHER("MOM_DAD_GETTING_TOGETHER", "20170327", "帅豪爸爸和猪猪妈妈在一起的日子");

    private String key;
    private String value;
    private String des;

    EnumAnniversaries(String key, String value, String des){
        this.key = key;
        this.value = value;
        this.des = des;
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
