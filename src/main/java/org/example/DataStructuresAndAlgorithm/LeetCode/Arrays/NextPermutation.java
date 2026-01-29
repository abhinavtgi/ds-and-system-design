package org.example.DataStructuresAndAlgorithm.LeetCode.Arrays;

//https://leetcode.com/problems/next-permutation/description/
public class NextPermutation {
    void reverseArray(int[] nums, int start, int end) {
        int n = nums.length;
        if(end>=n) {
            return;
        }
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {

        int n = nums.length;

        int indexToSwap = -1;

        for (int i = n - 1; i >= 1; i--) {
            //whenever we found 1st violation from end that is nums[i]>nums[i-1]
            //then we found the min index greater than nums[i-1] and swap it from nums[i-1]
            //and sort the remaining part
            if (nums[i] > nums[i - 1]) {
                int minimum = nums[i];
                int indexToSort = i;
                indexToSwap = i;

                //find the next element greater than nums[i-1] but minimum among all
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] <= nums[i] && nums[j] > nums[i - 1]) {
                        minimum = nums[j];
                        indexToSwap = j;
                    }
                }
                int temp = nums[indexToSwap];
                nums[indexToSwap] = nums[i - 1];
                nums[i - 1] = temp;

                //since i to end is already decreasing order because no violation till there
                //so we just reverse that part
                reverseArray(nums, indexToSort, n-1);
                return;
            }
        }

        //no violation happened so array is in dec order so we reverse it as per question
        if (indexToSwap == -1) {
            reverseArray(nums, 0, n-1);
        }
    }
}
