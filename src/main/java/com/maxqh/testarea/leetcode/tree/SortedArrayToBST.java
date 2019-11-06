package com.maxqh.testarea.leetcode.tree;

/**
 * @Author:qianhao
 * @Description:
 * @Date:2019/3/18
 * @Version:1.0
 */

/*
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */

/*
 * 成功 显示详情 执行用时 : 1 ms, 在Convert Sorted Array to Binary Search
 * Tree的Java提交中击败了97.11% 的用户 内存消耗 : 37.6 MB, 在Convert Sorted Array to Binary
 * Search Tree的Java提交中击败了0.71% 的用户
 */
public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }

        int middle = nums.length / 2;

        TreeNode result = new TreeNode(nums[middle]);

        helper(result, nums, 0, middle, nums.length - 1);
        return result;
    }

    private static void helper(TreeNode result, int[] nums, int low, int middle, int top) {
        if (middle > 0) {
            int leftMiddle = (middle + low) / 2;
            result.left = new TreeNode(nums[leftMiddle]);
            helper(result.left, nums, low, leftMiddle, middle - 1);
        }

        if (top > middle) {
            int rightMiddle = (middle + top + 1) / 2;
            result.right = new TreeNode(nums[rightMiddle]);
            helper(result.right, nums, middle + 1, rightMiddle, top);
        }
    }

    public static void main(String[] args) {
        int[] param = {-10,-3,0,5,9};
        TreeNode result = sortedArrayToBST(param);
        System.out.println(result);
    }
}
