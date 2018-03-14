package com.maxqh.testarea.faster;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author:qianhao
 * @Description: 爸爸好腻害！ 妈妈要加油哦！
 * @Date:2018/3/13
 * @Version:1.0
 */
public class DadYouSoGood {
    /**
     * 一次最多处理的数据量
     */
    public static final Integer MAX_NUM = 50000000;

    /**
     * 要运算总数
     */
    public static Integer TOTOAL_NUM = 100000000;

    private static final ExecutorService threadPool = new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors() + 1, Runtime.getRuntime().availableProcessors() * 2, 60L,
            TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

    public static void main(String[] args) throws Exception {
        methodA();

        Thread.sleep(1000);
        methodB();

        Thread.sleep(1000);
        methodC();

        Thread.sleep(1000);
        methodD();
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
        System.out
                .println(String.format("多线程计算： total num=[%s], and it costs[%s]ms \n\r", total, (endTime - startTime)));
    }

    public static void methodD() throws Exception {
        Long startTime = System.currentTimeMillis();

        int start = 0;
        int end = TOTOAL_NUM;

        for (; (end - start) > MAX_NUM;) {
            SubThread sub = new SubThread(start, start + MAX_NUM);
            start = start + MAX_NUM + 1;
            threadPool.submit(sub);
        }

        if (start < end) {
            SubThread sub = new SubThread(start, end);
            threadPool.submit(sub);
        }

        threadPool.shutdown();

        while (true) {
            if (threadPool.isTerminated()) {
                Long endTime = System.currentTimeMillis();
                System.out.println(String.format("多线程计算： totalNum=[%s], and it costs[%s]ms", SubThread.totalSum,
                        (endTime - startTime)));
                break;
            }
        }
    }
}
