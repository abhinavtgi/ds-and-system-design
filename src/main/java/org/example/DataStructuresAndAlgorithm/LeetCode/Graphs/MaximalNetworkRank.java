package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

//https://leetcode.com/problems/maximal-network-rank/description/
public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {

        //check number of roads for each city and if i,j city is connected
        int[] numberOfRoads = new int[n];
        boolean[][] isConnected = new boolean[n][n];

        for(int[]i:roads) {
            numberOfRoads[i[0]]++;
            numberOfRoads[i[1]]++;
            isConnected[i[0]][i[1]]=true;
            isConnected[i[1]][i[0]]=true;
        }

        int maxNetworkRank=0;

        //we will check all pairs (i,j) for their network ranks and update maxNetworkRank
        //no other way possible, we will have to check all pairs
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {

                //this is network rank of 2 nodes i and j
                int currentNetworkRank = numberOfRoads[i] + numberOfRoads[j];

                //if nodes are connected then decrease by 1 because its counted twice
                if(isConnected[i][j]) {
                    currentNetworkRank--;
                }

                //update maxNetworkRank
                maxNetworkRank = Math.max(maxNetworkRank, currentNetworkRank);
            }
        }
        return maxNetworkRank;
    }
}
