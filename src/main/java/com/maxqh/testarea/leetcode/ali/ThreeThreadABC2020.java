package com.maxqh.testarea.leetcode.ali;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:qianhao
 * @Description:  评测题目: 有3个线程A/B/C，其中A、B个线程轮流打印1-100 中间如果是10的倍数，则由C线程打印；
 * @Date:2018/11/15
 * @Version:1.0
 */
public class ThreeThreadABC2020 {

    private static AtomicInteger totalCountNum = new AtomicInteger(1);

    public static void main(String[] args){
        Long startTime = System.currentTimeMillis();

        Thread threadA = new Thread(new Runnable(){
            @Override
            public void run(){
                for(;;){
                    int totalTemp = totalCountNum.get();

                    if (totalTemp % 10 == 0){
                        continue;
                    }

                    int flag = (totalTemp / 10 + totalTemp % 2) % 2;

                    // 结束校验
                    if(isOver(totalTemp)){
                        System.out.println(System.currentTimeMillis() - startTime);
                        break;
                    }

                    if(totalTemp % 10 > 0 && flag == 1){
                        if(totalCountNum.compareAndSet(totalTemp, totalTemp + 1)){
                            System.out.println("A线程输出. count:" + totalTemp);
                        }
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable(){
            @Override
            public void run(){
                for(;;){
                    int totalTemp = totalCountNum.get();

                    if (totalTemp % 10 == 0){
                        continue;
                    }

                    int flag = (totalTemp / 10 + totalTemp % 2) % 2;
                    // 结束校验
                    if(isOver(totalTemp)){
                        System.out.println(System.currentTimeMillis() - startTime);
                        break;
                    }

                    if(flag == 0){
                        if(totalCountNum.compareAndSet(totalTemp, totalTemp + 1)){
                            System.out.println("B线程输出. count:" + totalTemp);
                        }
                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable(){
            @Override
            public void run(){
                for(;;){
                    int totalTemp = totalCountNum.get();

                    // 结束校验
                    if(isOver(totalTemp)){
                        System.out.println(System.currentTimeMillis() - startTime);
                        break;
                    }

                    if((totalTemp % 10 == 0)){
                        if(totalCountNum.compareAndSet(totalTemp, totalTemp + 1)){
                            System.out.println("C线程输出. count:" + totalTemp);
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
    public static boolean isOver(int count){
        return count > 10000;
    }
}
