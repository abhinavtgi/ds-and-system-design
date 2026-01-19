package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import org.example.DataStructuresAndAlgorithm.LeetCode.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
public class ConvertSortedListToBinarySearchTree {
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

    //convert linkedlist to array and then same as LC 108
    public TreeNode sortedListToBST(ListNode head) {
        ListNode current = head;
        List<Integer> sortedTree = new ArrayList<>();

        while(current!=null) {
            sortedTree.add(current.val);
            current=current.next;
        }

        return sortedListToBST(sortedTree, 0, sortedTree.size()-1);
    }
}
