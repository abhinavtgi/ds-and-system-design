package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

//https://leetcode.com/problems/max-area-of-island/description/
public class MaxAreaOfIsland {
    int getMaxArea(int i, int j, int[][] grid, int m, int n, boolean[][] visited) {
        if (i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        return 1 + getMaxArea(i + 1, j, grid, m, n, visited) + getMaxArea(i - 1, j, grid, m, n, visited)
                + getMaxArea(i, j + 1, grid, m, n, visited) + getMaxArea(i, j - 1, grid, m, n, visited);
    }

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, getMaxArea(i, j, grid, m, n, visited));
                }
            }
        }
        return maxArea;
    }
}
