package com.maxqh.biz.dal.jsontest;

import java.util.List;

/**
 * @Author:qianhao
 * @Description: 最外层class
 * @Date:2018/3/30
 * @Version:1.0
 */
public class ObjectBigOne {
    private Integer status;
    private String message;
    private List<ObjectA> result;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ObjectA> getResult() {
        return result;
    }

    public void setResult(List<ObjectA> result) {
        this.result = result;
    }
}
