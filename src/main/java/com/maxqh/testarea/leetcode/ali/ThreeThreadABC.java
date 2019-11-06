package com.maxqh.testarea.leetcode.ali;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:qianhao
 * @Description:  评测题目: 有3个线程A/B/C，其中A、B个线程轮流打印1-100 中间如果是10的倍数，则由C线程打印；
 * @Date:2018/11/15
 * @Version:1.0
 */
public class ThreeThreadABC {
    /**
     * 计数总数
     *//*
    private static AtomicInteger totalNum = new AtomicInteger(1);
    *//**
     * 是否该A打印
     *//*
    private static AtomicBoolean isATrun = new AtomicBoolean(Boolean.TRUE);

    public static void main(String[] args) {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){
                    int temp = totalNum.get();
                    if(temp > 100){
                        break;
                    }

                    if((temp % 10) > 0 && (Boolean.TRUE.equals(isATrun.get()))){
                        if(totalNum.compareAndSet(temp, temp + 1)){
                            System.out.println("A:"+ temp+ ","+isATrun);
                            isATrun.compareAndSet(Boolean.TRUE, Boolean.FALSE);
                        }
                    }
                }

            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){
                    int temp = totalNum.get();
                    if(temp > 100){
                        break;
                    }

                    if((temp % 10) > 0 && Boolean.FALSE.equals(isATrun.get())){
                        // 不为十的倍数 并且该B输出
                        if(totalNum.compareAndSet(temp, temp + 1)){
                            System.out.println("B:" + temp + ","+isATrun);
                            isATrun.compareAndSet(Boolean.FALSE, Boolean.TRUE);
                        }
                    }
                }
            }
        });

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){
                    int temp = totalNum.get();
                    if(temp > 100){
                        break;
                    }

                    if((temp % 10 == 0)){
                        // 十的倍数 改C输出
                        if(totalNum.compareAndSet(temp, temp + 1)){
                            System.out.println("C:" + temp + ",    这是C。"+isATrun);
                        }
                    }
                }
            }
        });

        a.start();
        b.start();
        c.start();
    }*/

    private static AtomicInteger totalCountNum = new AtomicInteger(1);
    private static AtomicInteger abCountNum = new AtomicInteger(0);

    public static void main(String[] args){

        Thread threadA = new Thread(new Runnable(){
            @Override
            public void run(){
                for(;;){
                    int totalTemp = totalCountNum.get();
                    int abTemp = abCountNum.get();

                    // 结束校验
                    if(isOver(totalTemp)){
                        break;
                    }

                    if((totalTemp % 10 > 0) && ((abTemp % 2) == 0)){
                        if(totalCountNum.compareAndSet(totalTemp, totalTemp + 1)){
                            abCountNum.compareAndSet(abTemp, abTemp + 1);

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
                    int abTemp = abCountNum.get();

                    // 结束校验
                    if(isOver(totalTemp)){
                        break;
                    }

                    if((totalTemp % 10 > 0) && ((abTemp % 2) > 0)){
                        if(totalCountNum.compareAndSet(totalTemp, totalTemp + 1)){
                            abCountNum.compareAndSet(abTemp, abTemp + 1);

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
        return count > 100;
    }
}
