package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
public class LongestZigZagPathInABinaryTree {
    int maxZigZagLength = 0;

    //direction tells where should we next node go 0 for left and 1 for right
    void getLongestZigZag(TreeNode root, int direction, int currentLength) {
        if (root == null) {
            return;
        }

        //if this node was asked to go to left by parent i.e. 0 and it went left so we increase length
        //otherwise reset length to 1
        int leftLength = direction == 0 ? currentLength + 1 : 1;

        //if this node was asked to go to right by parent i.e. 1 and it went right so we increase length
        //otherwise reset length to 1
        int rightLength = direction == 1 ? currentLength + 1 : 1;

        //calculate max zigzag length as currentLength
        maxZigZagLength = Math.max(maxZigZagLength, currentLength);

        //move left and ask next node to move right i.e. 0 to form zigzag
        getLongestZigZag(root.left, 1, leftLength);

        //move left and ask next node to move right i.e. 0 to form zigzag
        getLongestZigZag(root.right, 0, rightLength);

    }

    public int longestZigZag(TreeNode root) {

        //root can ask next node to move right or left as zigzag form both ways
        getLongestZigZag(root, 0, 0);
        getLongestZigZag(root, 1, 0);

        return maxZigZagLength;
    }
}
