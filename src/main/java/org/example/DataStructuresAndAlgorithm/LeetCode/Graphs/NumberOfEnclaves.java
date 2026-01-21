package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

//https://leetcode.com/problems/number-of-enclaves/description/
public class NumberOfEnclaves {
    void checkCanReachLand(int i, int j, int[][] grid, int m, int n) {
        if (i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        checkCanReachLand(i + 1, j, grid, m, n);
        checkCanReachLand(i - 1, j, grid, m, n);
        checkCanReachLand(i, j + 1, grid, m, n);
        checkCanReachLand(i, j - 1, grid, m, n);
    }

    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        for(int i=0;i<m;i++) {
            checkCanReachLand(i, 0, grid, m, n);
            checkCanReachLand(i, n-1, grid, m, n);
        }

        for(int j=0;j<n;j++) {
            checkCanReachLand(0, j, grid, m, n);
            checkCanReachLand(m-1,j, grid, m, n);
        }

        int unreachableLandCells=0;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1) {
                    unreachableLandCells++;
                }
            }
        }

        return unreachableLandCells;
    }
}
