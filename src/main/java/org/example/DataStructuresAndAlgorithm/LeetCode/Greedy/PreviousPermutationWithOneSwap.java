package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

//https://leetcode.com/problems/previous-permutation-with-one-swap/description/
public class PreviousPermutationWithOneSwap {
    public int[] prevPermOpt1(int[] arr) {

        int n = arr.length;

        //idea is to start from end and whenever arr[i-1] is greater than arr[i]
        // that means we dont have monotonic increasing sequence anymore and
        //less number is possible. Now since arr[i-1] is bigger
        //we have to swap it with some lower value than this but that should be max among all so we have
        //just smaller number
        for ( int i = n-1; i >= 1; i-- ) {

            //first time violation so we will break here only to get just smaller value
            //other violations will result in smaller number
            if(arr[i] < arr[i-1]) {

                //find number on the right which is smaller than arr[i-1] and biggest among them all
                int indexToSwap=i;
                for(int j=i;j<n;j++) {
                    if(arr[j]<arr[i-1] && arr[j]>arr[indexToSwap]) {
                        indexToSwap=j;
                    }
                }

                //swap the 2 values and break
                int temp = arr[indexToSwap];
                arr[indexToSwap] = arr[i-1];
                arr[i-1] = temp;
                break;
            }
        }

        return arr;
    }
}
