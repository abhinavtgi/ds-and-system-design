package org.example.DataStructuresAndAlgorithm.LeetCode.Arrays;

//https://leetcode.com/problems/sort-colors/description/
public class SortColors {
    // O(1) space solution
    public void sortColors(int[] nums) {

        //idea is that everything from 0 to low-1 is 0s, low to mid-1 is 1s
        //mid to high is unsorted, high+1 to n-1 is all 2's
        //so we move 3 pointers as per the cases.
        int low=0;
        int mid=0;
        int high=nums.length-1;

        while(mid<=high) {
            //we move zero to low and now 0 to low is all 0s so we low++ and now mid+1 to high is
            //unsorted so mid++
            if(nums[mid]==0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            //low to mid-1 was all 1s now we have low to mid all 1s so we just mid++
            else if(nums[mid]==1) {
                mid++;
            }

            //high+1 to n-1 was all 2s, but we move 2 at high and now high to n-1 all 2s so we high--
            else if(nums[mid]==2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
