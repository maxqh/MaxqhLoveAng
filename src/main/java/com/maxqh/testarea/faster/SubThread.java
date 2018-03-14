package com.maxqh.testarea.faster;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author:qianhao
 * @Description: 子线程
 * @Date:2018/3/14
 * @Version:1.0
 */
public class SubThread extends Thread {
    public static AtomicLong totalSum = new AtomicLong(0);

    private static Integer taskNum = 0;

    private int start;
    private int end;

    SubThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        Long tmp = 0L;
        for (; start <= end; start++) {
            tmp = tmp + start;
        }

        totalSum.getAndAdd(tmp);
        System.out.println(String.format("Thread任务分解.第[%s]次分解 start=[%s], end=[%s], total=[%s], time=[%s]", taskNum++,
                start, end, totalSum, System.currentTimeMillis()));
    }
}
