package com.maxqh.testarea.leetcode.array;

import com.maxqh.testarea.leetcode.Heap.HeapPriority;
import com.maxqh.testarea.sort.QuickSort;

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
    /**
     * 执行结果： 通过 显示详情 执行用时 : 6 ms , 在所有 Java 提交中击败了 61.33% 的用户 内存消耗 : 40.5 MB , 在所有
     * Java 提交中击败了 6.12% 的用户
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (Integer item : nums) {
            add(minHeap, item, k);
        }

        return minHeap.peek();
    }

    private static void add(PriorityQueue<Integer> minHeap, Integer item, int k) {
        if (minHeap.size() < k) {
            minHeap.add(item);
        } else if (minHeap.peek() < item) {
            minHeap.poll();
            minHeap.offer(item);
        }
    }

    /**
     * 执行结果： 通过 显示详情 执行用时 : 5 ms , 在所有 Java 提交中击败了 65.13% 的用户 内存消耗 : 40.4 MB , 在所有
     * Java 提交中击败了 6.12% 的用户
     * 
     * @param nums
     * @param k
     * @return
     * @throws Exception
     */
    public static int findKthLargestOptimize(int[] nums, int k) throws Exception {
        HeapPriority<Integer> minHeap = new HeapPriority<>(k);

        for (Integer item : nums) {
            add(minHeap, item, k);
        }

        return minHeap.peek();
    }

    private static void add(HeapPriority<Integer> minHeap, Integer item, int k) throws Exception {
        if (minHeap.size() < k) {
            minHeap.add(item);
        } else if (minHeap.peek() < item) {
            minHeap.remove(0);
            minHeap.add(item);
        }
    }

    /**
     * 执行用时：81 ms 内存消耗：40.8 MB
     *
     * 击败了0%的用户
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargestVoilence(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return 0;
        }

        QuickSort.fastSort(nums, 0, nums.length - 1);

        return nums[nums.length - k];
    }

    public static void main(String[] args) throws Exception {
        int[] param = {};
        System.out.println(findKthLargestOptimize(param, 918));
    }
}