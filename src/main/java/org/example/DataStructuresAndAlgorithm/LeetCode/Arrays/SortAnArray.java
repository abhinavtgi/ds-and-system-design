package org.example.DataStructuresAndAlgorithm.LeetCode.Arrays;

//https://leetcode.com/problems/sort-an-array/description/
public class SortAnArray {
    int[] mergeTwoSortedList(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] sortedList = new int[n + m];

        int pointer1 = 0;
        int pointer2 = 0;
        int index = 0;
        while (pointer1 < m && pointer2 < n) {
            if (nums1[pointer1] < nums2[pointer2]) {
                sortedList[index++] = nums1[pointer1++];
            } else {
                sortedList[index++] = nums2[pointer2++];
            }
        }
        while (index < m + n) {
            if (pointer1 < m) {
                sortedList[index++] = nums1[pointer1++];
            } else {
                sortedList[index++] = nums2[pointer2++];
            }
        }

        return sortedList;
    }

    int[] mergeSort(int[] nums, int start, int end) {
        if (start > end) {
            return new int[0];
        }
        if (start == end) {
            return new int[] { nums[start] };
        }
        int mid = (start + end) / 2;
        int[] nums1 = mergeSort(nums, start, mid);
        int[] nums2 = mergeSort(nums, mid + 1, end);

        return mergeTwoSortedList(nums1, nums2);
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }
}
