package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.*;

//https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
public class MinimumMultiplicationsToReachEnd {
    static final int mod = 100_000;
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        Queue<Integer> q1 = new LinkedList<>();

        int maxElement=Arrays.stream(arr).max().getAsInt();

        int[] distances = new int[mod];
        Arrays.fill(distances,Integer.MAX_VALUE);

        q1.add(start);
        distances[start]=0;

        while(!q1.isEmpty()) {
            int current = q1.poll();
            for(int i:arr) {
                int newStart=(i*current)%mod;
                if(distances[current]+1<distances[newStart]) {
                    q1.add(newStart);
                    distances[newStart]=distances[current]+1;
                }
            }
        }

        return distances[end]==Integer.MAX_VALUE?-1:distances[end];
    }

}
