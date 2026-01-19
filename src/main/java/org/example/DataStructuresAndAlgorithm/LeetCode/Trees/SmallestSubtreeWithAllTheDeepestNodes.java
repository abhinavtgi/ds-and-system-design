package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/
public class SmallestSubtreeWithAllTheDeepestNodes {
    //get LCA of two nodes in a tree
    TreeNode lowestCommonAncestor(TreeNode p, TreeNode q, TreeNode root) {
        if(root==null) {
            return null;
        }
        if(root==p || root==q) {
            return root;
        }

        TreeNode leftLCA = lowestCommonAncestor(p,q,root.left);
        TreeNode rightLCA = lowestCommonAncestor(p,q,root.right);

        if(leftLCA==null) {
            return rightLCA;
        }
        else if(rightLCA==null) {
            return leftLCA;
        }
        else {
            return root;
        }
    }

    //idea is to find all the deepest leaves using BFS and find LCA for first and last nodes because
    //that LCA will cover all the nodes
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null) {
            return null;
        }

        Queue<TreeNode> q1 = new LinkedList<>();

        q1.add(root);

        List<TreeNode> levelNodes = new ArrayList<>();

        while(!q1.isEmpty()) {
            int size = q1.size();

            levelNodes = new ArrayList<>();

            for(int i=0;i<size;i++) {
                TreeNode current = q1.poll();
                levelNodes.add(current);
                if(current.left!=null) {
                    q1.add(current.left);
                }
                if(current.right!=null) {
                    q1.add(current.right);
                }
            }
        }

        TreeNode firstNode = levelNodes.get(0);
        TreeNode lastNode = levelNodes.get(levelNodes.size()-1);

        return lowestCommonAncestor(firstNode, lastNode, root);
    }
}
