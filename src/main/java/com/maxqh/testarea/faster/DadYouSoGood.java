package com.maxqh.testarea.faster;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * @Author:qianhao
 * @Description: 爸爸好腻害！ 妈妈要加油哦！
 * @Date:2018/3/13
 * @Version:1.0
 */
public class DadYouSoGood {
    /**
     * 一次最多处理50万数据
     */
    public static final Integer MAX_NUM = 50000000;

    /**
     * 要运算总数
     */
    public static Integer TOTOAL_NUM = 100000000;

    public static void main(String[] args) throws Exception {
//         methodA();
         methodB();
//         methodC();
    }

    /**
     * 同步执行
     */
    public static void methodA() {
        // 1:同步执行
        Long startTime = System.currentTimeMillis();
        Long total = 0L;
        for (int i = 0; i <= TOTOAL_NUM; i++) {
            total += i;
        }
        Long endTime = System.currentTimeMillis();
        System.out.println(String.format("total num=[%s], and it costs[%s]ms \n\r", total, (endTime - startTime)));
    }

    /**
     * ForkJoinPool异步提交
     * 
     * @throws Exception
     */
    public static void methodB() throws Exception {
        // 2:ForkJoinPool异步提交
        Long startTime = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 提交可分解的PrintTask任务
        Future<Long> future = forkJoinPool.submit(new SubTask(0, TOTOAL_NUM));
        Long total = future.get();
        // 关闭线程池
        forkJoinPool.shutdown();
        Long endTime = System.currentTimeMillis();
        System.out
                .println(String.format("多线程计算： total num=[%s], and it costs[%s]ms \n\r", total, (endTime - startTime)));
    }

    /**
     * Callable异步提交
     * 
     * @throws Exception
     */
    public static void methodC() throws Exception {
        // 3:Callable异步提交
        Long startTime = System.currentTimeMillis();
        SubCallable callable = new SubCallable(0, TOTOAL_NUM);
        Long total = callable.call();
        Long endTime = System.currentTimeMillis();
        System.out.println(String.format("多线程计算： total num=[%s], and it costs[%s]ms", total, (endTime - startTime)));
    }
}
