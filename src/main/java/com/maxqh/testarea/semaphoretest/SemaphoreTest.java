package com.maxqh.testarea.semaphoretest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:qianhao
 * @Description: Semaphore防死锁测试
 * @Date:2018/3/30
 * @Version:1.0
 */
public class SemaphoreTest {
    public static String SUCCESS = "success";

    public static String FAIL = "【fail】";

    public static String RELEASE = "release";


    private static AtomicInteger successNum = new AtomicInteger(0);

    private static Semaphore sourceA = new Semaphore(5);

    private static Semaphore sourceB = new Semaphore(5);

    private static Semaphore sourceC = new Semaphore(6);

    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(50, 100, 10, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000));
        Long start = System.currentTimeMillis();
        for (int i = 5; i > 0; i--) {
            ThreadA threadA = new ThreadA(sourceA, sourceB, sourceC, successNum.incrementAndGet());
            threadPool.submit(threadA);
        }

        //关闭线程  计算总耗时
        threadPool.shutdown();

        while (true) {
            if (threadPool.isTerminated()) {
                Long end = System.currentTimeMillis();
                System.out.println("RT:" + (end - start));
                break;
            }
        }

        /*.
         * for(int i = 50; i> 0 ; i--){ ThreadB threadB = new ThreadB(sourceA,
         * sourceB, sourceC, successNum.incrementAndGet());
         * threadPool.submit(threadB); }
         */

    }
}
