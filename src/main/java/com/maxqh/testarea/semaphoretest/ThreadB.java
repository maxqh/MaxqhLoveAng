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
public class ThreadB implements Runnable {
    private Integer taskNum;

    private Semaphore sourceA;

    private Semaphore sourceB;

    private Semaphore sourceC;

    ThreadB(Semaphore a, Semaphore b, Semaphore c, Integer taskNum) {
        this.taskNum = taskNum;
        this.sourceA = a;
        this.sourceB = b;
        this.sourceC = c;
    }

    private Logger LOG = LoggerFactory.getLogger(ThreadB.class);

    @Override
    public void run() {
        try {
            while (true) {
                if (sourceA.tryAcquire(3, 1000, TimeUnit.MILLISECONDS)) {
                    // LOG.info("TaskNum:{}, ThreadId:{} Get sourceA success.",
                    // taskNum, Thread.currentThread().getId());
                    if (sourceB.tryAcquire(2, 1000, TimeUnit.MILLISECONDS)) {
                        // LOG.info("TaskNum:{}, ThreadId:{} Get sourceB
                        // success.", taskNum, Thread.currentThread().getId());
                        if (sourceC.tryAcquire(1, 1000, TimeUnit.MILLISECONDS)) {
                            LOG.info("=================TaskNum:{}, ThreadId:{} Get sourceC success.=================",
                                    taskNum, Thread.currentThread().getId());
                            printf();

                            sourceA.release(3);
                            sourceB.release(2);
                            sourceC.release(1);
                            printf();
                            return;
                        }
                    }
                }

                // LOG.error("TaskNum:{}, Get source fail. {}", taskNum,
                // Thread.currentThread().getId());
                LOG.info("TaskNum:{}, get source fail", taskNum);
                printf();
            }
        } catch (InterruptedException e) {
            LOG.error("TaskNum:{}, ThreadB exception. errorInfo={}, ThreadId:{}", taskNum, e.getMessage(),
                    Thread.currentThread().getId());
            printf();
        }
    }

    public void printf() {
        LOG.info("TaskNum:{}, sourceLast A:{}, B:{}, C:{}", taskNum, sourceA.availablePermits(),
                sourceB.availablePermits(), sourceC.availablePermits());
    }
}
