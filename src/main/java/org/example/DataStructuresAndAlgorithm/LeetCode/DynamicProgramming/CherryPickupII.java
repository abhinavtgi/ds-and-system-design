package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/cherry-pickup-ii/description/
public class CherryPickupII {
    int maxCherryPicked(int i, int j1, int j2, int[][] grid, int m, int n, int[][][] dp) {
        if(i>=m || j1<0 || j1>=n || j2<0 || j2>=n) {
            return 0;
        }

        if(dp[i][j1][j2]!=-1) {
            return dp[i][j1][j2];
        }

        int cherries = j1 != j2 ?  grid[i][j1]+grid[i][j2] : grid[i][j1];

        int op1 = maxCherryPicked(i+1, j1-1, j2-1,grid,m,n,dp);
        int op2 = maxCherryPicked(i+1, j1+1, j2-1,grid,m,n,dp);
        int op3 = maxCherryPicked(i+1, j1, j2-1,grid,m,n,dp);

        int op4 = maxCherryPicked(i+1, j1-1, j2+1,grid,m,n,dp);
        int op5 = maxCherryPicked(i+1, j1+1, j2+1,grid,m,n,dp);
        int op6 = maxCherryPicked(i+1, j1, j2+1,grid,m,n,dp);

        int op7 = maxCherryPicked(i+1, j1-1, j2,grid,m,n,dp);
        int op8 = maxCherryPicked(i+1, j1+1, j2,grid,m,n,dp);
        int op9 = maxCherryPicked(i+1, j1, j2,grid,m,n,dp);

        int temp1 = Math.max(Math.max(Math.max(op1,op2),Math.max(op3,op4)),op5);
        int temp2 = Math.max(Math.max(op6,op7),Math.max(op8,op9));

        return dp[i][j1][j2] = cherries + Math.max(temp1,temp2);

    }
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int[][] i:dp) {
            for(int[] j:i) Arrays.fill(j,-1);
        }

        return maxCherryPicked(0, 0, n-1,grid,m,n,dp);
    }
}
