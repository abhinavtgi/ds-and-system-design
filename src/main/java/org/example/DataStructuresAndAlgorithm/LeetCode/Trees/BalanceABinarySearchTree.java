package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/balance-a-binary-search-tree/
public class BalanceABinarySearchTree {
    List<Integer> sortedTree;

    //convert sorted list to balanced BST, always go to mid.
    TreeNode sortedListToBST(List<Integer> sortedTree, int start, int end) {
        if(start>end) {
            return null;
        }
        int mid = start+(end-start)/2;

        TreeNode root = new TreeNode(sortedTree.get(mid));

        root.left = sortedListToBST(sortedTree, start, mid-1);
        root.right = sortedListToBST(sortedTree, mid+1, end);

        return root;

    }
    //inorder traversal of tree to get sorted list
    void convertTreeToSortedList(TreeNode root) {
        if(root==null) {
            return;
        }
        convertTreeToSortedList(root.left);
        sortedTree.add(root.val);
        convertTreeToSortedList(root.right);
    }

    //idea is to convert BST to sorted list using inorder traversal then convert that
    //sorted list to balanced BST using concept of LC 108. Convert Sorted Array to Binary Search Tree
    public TreeNode balanceBST(TreeNode root) {
        sortedTree = new ArrayList<>();
        convertTreeToSortedList(root);
        return sortedListToBST(sortedTree, 0, sortedTree.size()-1);
    }
}
