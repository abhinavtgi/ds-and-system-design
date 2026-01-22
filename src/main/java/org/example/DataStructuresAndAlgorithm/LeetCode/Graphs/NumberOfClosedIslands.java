package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

//https://leetcode.com/problems/number-of-closed-islands/description/
public class NumberOfClosedIslands {
    boolean checkClosedIsland(int i, int j, int m, int n, int[][] grid, boolean[][] visited) {
        if (i >= m || i < 0 || j >= n || j < 0) {
            return false;
        }
        if (grid[i][j] == 1 || visited[i][j]) {
            return true;
        }
        visited[i][j] = true;
        boolean down = checkClosedIsland(i + 1, j, m, n, grid, visited);
        boolean up = checkClosedIsland(i - 1, j, m, n, grid, visited);
        boolean right = checkClosedIsland(i, j + 1, m, n, grid, visited);
        boolean left = checkClosedIsland(i, j - 1, m, n, grid, visited);

        return down && up && right && left;
    }

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int totalClosedIslands=0;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==0 && !visited[i][j]) {
                    if(checkClosedIsland(i,j,m,n,grid,visited)) {
                        totalClosedIslands++;
                    }
                }
            }
        }

        return totalClosedIslands;
    }
}
