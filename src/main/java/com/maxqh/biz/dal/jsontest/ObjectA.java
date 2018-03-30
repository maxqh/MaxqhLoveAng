package com.maxqh.biz.dal.jsontest;

import java.util.List;

/**
 * @Author:qianhao
 * @Description: ObjectA
 * @Date:2018/3/30
 * @Version:1.0
 */
public class ObjectA {
    private List<ObjectB> prodinfos;
    private String msisdn;
    private String iccid;
    private String imsi;

    public List<ObjectB> getProdinfos() {
        return prodinfos;
    }

    public void setProdinfos(List<ObjectB> prodinfos) {
        this.prodinfos = prodinfos;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }
}
