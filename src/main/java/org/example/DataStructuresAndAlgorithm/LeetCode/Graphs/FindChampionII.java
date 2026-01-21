package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

//https://leetcode.com/problems/find-champion-ii/description/
public class FindChampionII {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];

        for(int[] i:edges) {
            indegree[i[1]]++;
        }

        int totalStrong=0;
        int champion=0;

        for(int i=0;i<n;i++) {
            if(indegree[i]==0) {
                totalStrong++;
                champion=i;
            }
        }

        return totalStrong > 1 ? -1 : champion;
    }
}
