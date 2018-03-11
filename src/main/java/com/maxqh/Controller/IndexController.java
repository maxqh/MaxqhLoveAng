package com.maxqh.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/3/11
 * @Version:1.0
 */
@RestController
public class IndexController {

    @GetMapping(value = "/maxqh")
    public String maxqh(){
        return "111111";
    }
}
