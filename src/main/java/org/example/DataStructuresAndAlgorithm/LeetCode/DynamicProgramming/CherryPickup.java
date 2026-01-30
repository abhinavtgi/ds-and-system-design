package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/cherry-pickup/description/
public class CherryPickup {
    int getMaxCherriesPicked(int i1, int j1, int i2, int j2, int[][] grid, int m, int n, int[][][] dp) {
        if (i1 >= m || i2 >= m || j1 >= n || j2 >= n || grid[i1][j1] == -1 || grid[i2][j2] == -1) {
            return -1000_000;
        }
        if (i1 == m-1 && i2 == m-1 && j1 == n-1 && j2 == n-1) {
            return grid[i1][j1];
        }
        if (dp[i1][j1][i2] != -1) {
            return dp[i1][j1][i2];
        }
        int cherries = i1 == i2 && j1 == j2 ? grid[i1][j1] : grid[i1][j1] + grid[i2][j2];

        int op1 = getMaxCherriesPicked(i1 + 1, j1, i2 + 1, j2, grid, m, n, dp);
        int op2 = getMaxCherriesPicked(i1, j1+1, i2, j2+1, grid, m, n, dp);
        int op3 = getMaxCherriesPicked(i1+1, j1, i2, j2+1, grid, m, n, dp);
        int op4 = getMaxCherriesPicked(i1, j1+1, i2+1, j2, grid, m, n, dp);
        return dp[i1][j1][i2] = cherries + Math.max(Math.max(op1, op2), Math.max(op3, op4));
    }

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // since both robo move 1 step  so i1+j1 = i2+j2,
        //so one variable is derived from other 3 so just remove 1 variable
        int[][][] dp = new int[m][n][m];
        for (int[][] i : dp) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }

        //instead of 2 paths just start 2 persons at (0,0) simultaneously,
        //this the the most diffcult part to come up for this problem
        //because if we have 2 paths 1st one start to end then end to start
        //then how will we track cherries that are picked in 1st path so that we dont
        //pick them again? That will need some extra storage and that defeats the whole purpose of
        //DP because then DP will also depend on that storage
        int cherriesPicked = getMaxCherriesPicked(0, 0, 0, 0, grid, m, n, dp);

        if (cherriesPicked < 0) {
            return 0;
        }

        return cherriesPicked;
    }
}
