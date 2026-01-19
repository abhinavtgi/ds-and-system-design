package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/description/
public class PseudoPalindromicPathsInABinaryTree {
    Map<Integer,Integer> frequencyMap;
    int totalPreudoPalindromicPaths=0;

    //check if map is pseduo palindrome
    //only one integer frequency can be greater than 1 at max
    //max map size is only 9 so this function is O(9)
    boolean checkIsPseudoPalindromicPath(Map<Integer,Integer> frequencyMap) {

        int countOddFrequency=0;

        for(Map.Entry<Integer,Integer> entry:frequencyMap.entrySet()) {
            if(entry.getValue()%2!=0) {
                countOddFrequency++;
            }

            //more than one odd frequency so return false
            if(countOddFrequency>1) {
                return false;
            }
        }

        return true;

    }

    //idea is to check all root to leaf path if they are pseudo palindrome
    //for a string to be pseudo palindrome all chars frequency should be even and only 1 char frequency
    //can be odd at max, because if even then we can place one at start and one at end and so on.
    void getPseudoPalindromicPaths(TreeNode root) {
        if(root==null) {
            return;
        }
        frequencyMap.put(root.val, frequencyMap.getOrDefault(root.val,0)+1);

        //root leaf so check if path is pseudo palindrome and increment count
        if(root.left==null && root.right==null) {
            if(checkIsPseudoPalindromicPath(frequencyMap)) {
                totalPreudoPalindromicPaths++;
            }
        }
        getPseudoPalindromicPaths(root.left);
        getPseudoPalindromicPaths(root.right);

        //backtrack
        frequencyMap.put(root.val, frequencyMap.getOrDefault(root.val,0)-1);
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        frequencyMap = new HashMap<>();
        getPseudoPalindromicPaths(root);
        return totalPreudoPalindromicPaths;
    }
}
