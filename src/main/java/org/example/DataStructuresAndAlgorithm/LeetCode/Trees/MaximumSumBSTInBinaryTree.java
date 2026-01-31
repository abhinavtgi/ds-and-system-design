package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/description/
public class MaximumSumBSTInBinaryTree {
    //track max BST sum accross the tree
    int maxBstSum;

    //tree is bst when both left and right sides are BST and
    //root.val>leftMax and root.right<rightMin, postorder traveral is needed.
    //returns sum, isBst, min, max
    int[] getSumAndBst(TreeNode root) {
        if(root==null) {
            return new int[]{0,1,Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] left = getSumAndBst(root.left);
        int[] right = getSumAndBst(root.right);

        //if both left and right are BST and root.val > leftMax and root.val<rightMin
        if(left[1]==1 && right[1]==1 && root.val>left[3] && root.val<right[2]) {
            int sum = root.val + left[0] + right[0];

            //update maxSum only if its valid BST
            maxBstSum = Math.max(maxBstSum, sum);

            //what is min for this subtree, could be root or min from left, cant be right if its BST
            int min = Math.min(root.val, left[2]);

            //what is max in this subtree, could be root or max from right
            int max = Math.max(root.val, right[3]);

            return new int[]{sum, 1, min, max};
        }

        return new int[]{0, 0, 0, 0};
    }
    public int maxSumBST(TreeNode root) {
        maxBstSum=0;
        getSumAndBst(root);
        return maxBstSum;
    }
}
