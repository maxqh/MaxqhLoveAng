package com.maxqh.testarea.faster;

import java.util.concurrent.Callable;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/3/13
 * @Version:1.0
 */
public class SubCallable implements Callable<Long> {
    /**
     * 子线程数量
     */
    private static Integer taskNum = 0;
    private Integer start;
    private Integer end;

    SubCallable(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() throws Exception {
        Long total = 0L;
        if ((end - start) <= DadYouSoGood.MAX_NUM) {
            for (; start <= end; start++) {
                total = total + start;
            }
            return total;
        } else {
            System.out.println(String.format("Callable任务分解.第[%s]次分解 start=[%s], end=[%s]", taskNum++, start, end));
            int middle = (start + end) / 2;
            SubCallable left = new SubCallable(start, middle);
            SubCallable right = new SubCallable(middle + 1, end);
            return left.call() + right.call();
        }
    }
}
