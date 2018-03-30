package com.maxqh.biz.dal.jsontest;

/**
 * @Author:qianhao
 * @Description: ObjectB
 * @Date:2018/3/30
 * @Version:1.0
 */
public class ObjectB {
    private String prodId;  //套餐资费编号
    private String prodName;  //SIM卡套餐名称
    private String prodinstefftime; //套餐生效时间
    private String prodinstexptime;  //套餐失效时间

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdinstefftime() {
        return prodinstefftime;
    }

    public void setProdinstefftime(String prodinstefftime) {
        this.prodinstefftime = prodinstefftime;
    }

    public String getProdinstexptime() {
        return prodinstexptime;
    }

    public void setProdinstexptime(String prodinstexptime) {
        this.prodinstexptime = prodinstexptime;
    }
}
