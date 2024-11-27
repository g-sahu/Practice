package com.practice.leetcode;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length-1);
    }

    TreeNode createBST(int[] nums, int l, int r) {
        if(l > r) {
            return null;
        }

        int mid = l + (r - l)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = createBST(nums, l, mid-1);
        node.right = createBST(nums, mid+1, r);
        return node;
    }
}
