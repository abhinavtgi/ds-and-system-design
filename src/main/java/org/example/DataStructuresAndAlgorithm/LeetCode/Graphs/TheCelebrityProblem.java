package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

public class TheCelebrityProblem {
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;

        int[] indegree = new int[n];
        int[] outdegree = new int[n];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i!=j && mat[i][j]==1) {
                    indegree[j]++;
                    outdegree[i]++;
                }
            }
        }

        for(int i=0;i<n;i++) {
            if(indegree[i]==n-1 && outdegree[i]==0) {
                return i;
            }
        }

        return -1;
    }
}
