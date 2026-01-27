package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

public class SpecialMatrix {
    static final int mod=1000_000_007;
    int countTotalWays(int i, int j, int n, int m, int[][] maze, int[][] totalWaysMemo) {
        if(i>=n || j>=m || maze[i][j]==1) {
            return 0;
        }
        if(i==n-1 && j==m-1) {
            return 1;
        }

        if(totalWaysMemo[i][j]!=-1) {
            return totalWaysMemo[i][j];
        }

        int down = countTotalWays(i+1,j,n,m,maze, totalWaysMemo)%mod;
        int right = countTotalWays(i,j+1,n,m,maze, totalWaysMemo)%mod;

        return totalWaysMemo[i][j] = (down+right)%mod;
    }
    public int FindWays(int n, int m, int[][] blocked_cells) {
        // Code here
        int[][] maze = new int[n][m];
        for(int[] i:blocked_cells) {
            int blockedI = i[0]-1;
            int blockedJ = i[1]-1;
            maze[blockedI][blockedJ]=1;
        }

        int[][] totalWaysMemo = new int[n][m];

        for(int[] i: totalWaysMemo) Arrays.fill(i,-1);

        return countTotalWays(0,0,n,m,maze, totalWaysMemo);
    }
}
