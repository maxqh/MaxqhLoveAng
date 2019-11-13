package com.maxqh.testarea.leetcode.array;

import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * @program: maxqh_love_ang
 * @description:
 * @author: qianhao
 * @create: 2019-11-13 10:24
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (Integer item : nums) {
            add(minHeap, item, k);
        }

        return minHeap.peek();
    }

    private void add(PriorityQueue<Integer> minHeap, Integer item, int k) {
        if (minHeap.size() < k) {
            minHeap.add(item);
        } else if (minHeap.peek() < item) {
            minHeap.poll();
            minHeap.offer(item);
        }
    }

    // TODO 实现PriorityQueue小顶堆
}