package org.example.DataStructuresAndAlgorithm.LeetCode.Arrays;

//https://leetcode.com/problems/maximum-sum-circular-subarray/
public class MaximumSumCircularSubarray {
    // Use Kaden's algorithm:
    // find max_sum
    // find min_sum
    // find max of max_sum and total_sum - (-min_sum)
    public int maxSubarraySumCircular(int[] nums) {

        int maxSum=0;
        int minSum=Integer.MAX_VALUE;

        int currentMaxSum=0;
        int currentMinSum=0;

        int totalSum=0;
        boolean allNegative=true;
        int n = nums.length;

        for(int i=0;i<n;i++) {
            totalSum+=nums[i];
            int number = nums[i];
            if(number>0) {
                allNegative=false;
            }
            currentMaxSum+=number;
            if(currentMaxSum<0) {
                currentMaxSum=0;
            }
            maxSum=Math.max(maxSum, currentMaxSum);

            currentMinSum+=number;
            if(currentMinSum>0) {
                currentMinSum=0;
            }
            minSum=Math.min(minSum,currentMinSum );
        }


        //handle all negative case, take max element
        if(allNegative) {
            int maxElement=Integer.MIN_VALUE;
            for(int i:nums) {
                maxElement=Math.max(maxElement, i);
            }
            return maxElement;
        }

        return Math.max(maxSum, totalSum-minSum);
    }
}
