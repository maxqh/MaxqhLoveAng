package com.maxqh.testarea.semaphoretest;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2018/3/30
 * @Version:1.0
 */
public class ThreadA implements Runnable {
    private Integer taskNum;

    private Semaphore sourceA;

    private Semaphore sourceB;

    private Semaphore sourceC;

    private Logger LOG = LoggerFactory.getLogger(ThreadA.class);

    ThreadA(Semaphore a, Semaphore b, Semaphore c, Integer taskNum) {
        this.taskNum = taskNum;
        this.sourceA = a;
        this.sourceB = b;
        this.sourceC = c;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (sourceA.tryAcquire(1, 10, TimeUnit.MILLISECONDS)) {
                    Thread.sleep(200);
                    // LOG.info("TaskNum:{}, ThreadId:{} Get sourceA success.",
                    // taskNum, Thread.currentThread().getId());
                    if (sourceB.tryAcquire(2, 10, TimeUnit.MILLISECONDS)) {
                        Thread.sleep(800);
                        // LOG.info("TaskNum:{}, ThreadId:{} Get sourceB
                        // success.", taskNum, Thread.currentThread().getId());
                        if (sourceC.tryAcquire(3, 10, TimeUnit.MILLISECONDS)) {
                            Thread.sleep(200);
                            LOG.info("=================TaskNum:{}, ThreadId:{} Get sourceC success.=================",
                                    taskNum, Thread.currentThread().getId());
                            printf(SemaphoreTest.SUCCESS);

                            sourceA.release(1);
                            sourceB.release(2);
                            sourceC.release(3);
                            printf(SemaphoreTest.RELEASE);
                            return;
                        }
                    }
                }

                // LOG.error("TaskNum:{}, Get source fail. {}", taskNum,
                // Thread.currentThread().getId());
                LOG.info("TaskNum:{}, get source fail", taskNum);
                printf(SemaphoreTest.FAIL);
            }
        } catch (InterruptedException e) {
            LOG.error("TaskNum:{}, ThreadA exception. errorInfo={}, ThreadId:{}", taskNum, e.getMessage(),
                    Thread.currentThread().getId());
            printf(SemaphoreTest.FAIL);
        }
    }

    public void printf(String bizStr) {
        LOG.info("TaskNum:{}, bizStr:{}, sourceLast A:{}, B:{}, C:{}", taskNum, bizStr, sourceA.availablePermits(),
                sourceB.availablePermits(), sourceC.availablePermits());
    }
}
