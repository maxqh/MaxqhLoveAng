package com.maxqh.Controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxqh.biz.manager.enums.EnumAnniversaries;
import com.maxqh.biz.manager.utils.DateUtils;

/**
 * @Author:qianhao
 * @Description: 纪念日
 * @Date:2018/3/11
 * @Version:1.0
 */
@RestController(value = "/momdad")
public class AnniversaryController {
    @GetMapping(value = "/days")
    public Integer days(){
        String gettingTogetherDayStr = EnumAnniversaries.MOM_DAD_GETTING_TOGETHER.getValue();
        String nowDateStr = DateUtils.getYmdDateString(new Date());

        Integer days = Integer.valueOf(nowDateStr) - Integer.valueOf(gettingTogetherDayStr);
        return days;
    }

}
