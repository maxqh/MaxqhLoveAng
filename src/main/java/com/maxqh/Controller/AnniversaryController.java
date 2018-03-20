package com.maxqh.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxqh.biz.manager.enums.EnumAnniversaries;
import com.maxqh.biz.manager.utils.DateUtils;

/**
 * @Author:qianhao
 * @Description: 纪念日
 * @Date:2018/3/11
 * @Version:1.0
 */
@RestController
@RequestMapping(value = "/momdad")
public class AnniversaryController {
    @GetMapping(value = "/days")
    public Long days(){
        String gettingTogetherDayStr = EnumAnniversaries.MOM_DAD_GETTING_TOGETHER.getValue();

        Long days = DateUtils.getDaysFromNow(gettingTogetherDayStr);
        return days;
    }

}
