package com.maxqh.testarea.faster;



import java.util.concurrent.RecursiveTask;

/**
 * @Author:qianhao
 * @Description: 子任务
 * @Date:2018/3/13
 * @Version:1.0
 */
public class SubTask extends RecursiveTask<Long> {

    /**
     * 子任务数目
     */
    public static Integer taskNum = 1;
    private int start;
    private int end;

    SubTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if ((end - start) <= DadYouSoGood.MAX_NUM) {
            Long total = 0L;
            for (; start <= end; start++) {
                total = total + start;
            }
            return total;
        } else {
            System.out.println(String.format("RecursiveTask任务分解.第[%s]次分解 start=[%s], end=[%s]", taskNum++, start, end));
            // 将大任务分解成两个小任务
            int middle = (start + end) / 2;
            SubTask left = new SubTask(start, middle);
            SubTask right = new SubTask(middle + 1, end);
            // 执行子任务
            left.fork();
            right.fork();
            return left.join() + right.join();

        }
    }
}
