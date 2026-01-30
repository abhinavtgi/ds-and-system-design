package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/cherry-pickup-ii/description/
public class CherryPickupII {
    int[][] directions = {{-1,0}, {-1,1}, {-1,-1}, {0,0},{0,-1},{0,1},{1,0},{1,-1},{1,1}};
    int maxCherryPicked(int i, int j1, int j2, int[][] grid, int m, int n, int[][][] dp) {
        if(i>=m || j1<0 || j1>=n || j2<0 || j2>=n) {
            return 0;
        }

        if(dp[i][j1][j2]!=-1) {
            return dp[i][j1][j2];
        }

        int cherries = j1 != j2 ?  grid[i][j1]+grid[i][j2] : grid[i][j1];
        int maxCherriesPicked=0;
        for(int[] dir:directions) {
            int newI = i+1;
            int newJ1= j1+dir[0];
            int newJ2 = j2+dir[1];
            int totalCherries = cherries + maxCherryPicked(newI, newJ1, newJ2,grid,m,n,dp);
            maxCherriesPicked = Math.max(maxCherriesPicked, totalCherries);
        }

        return dp[i][j1][j2] = maxCherriesPicked;

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
