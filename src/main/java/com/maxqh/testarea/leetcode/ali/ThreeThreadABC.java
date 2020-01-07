package com.maxqh.testarea.leetcode.ali;

/**
 * @Author:qianhao
 * @Description: 评测题目: 有3个线程A/B/C，其中A、B个线程轮流打印1-100 中间如果是10的倍数，则由C线程打印；
 * @Date:2018/11/15
 * @Version:1.0
 */
public class ThreeThreadABC {
    private static volatile Integer totalCountNum = 1;

    public static void main(String[] args) {

        Long startTime = System.currentTimeMillis();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {

                    synchronized (totalCountNum) {
                        if (totalCountNum % 10 == 0) {
                            continue;
                        }

                        // 结束校验
                        if (isOver(totalCountNum)) {
                            System.out.println(System.currentTimeMillis() - startTime);
                            break;
                        }

                        if (((totalCountNum / 10 + totalCountNum % 2) % 2 == 1)) {
                            System.out.println("A线程输出. count:" + totalCountNum++);
                        }
                    }

                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {

                    synchronized (totalCountNum) {
                        if (totalCountNum % 10 == 0) {
                            continue;
                        }

                        // 结束校验
                        if (isOver(totalCountNum)) {
                            System.out.println(System.currentTimeMillis() - startTime);
                            break;
                        }

                        if (((totalCountNum / 10 + totalCountNum % 2) % 2 == 0)) {
                            System.out.println("B线程输出. count:" + totalCountNum++);
                        }
                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    synchronized (totalCountNum) {
                        if (totalCountNum % 10 == 0) {
                            System.out.println("C线程输出. count:" + totalCountNum++);
                            continue;
                        }

                        // 结束校验
                        if (isOver(totalCountNum)) {
                            System.out.println(System.currentTimeMillis() - startTime);
                            break;
                        }
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }

    /*
     * 是否计时结束
     */
    public static boolean isOver(int count) {
        return count > 10000;
    }
}
