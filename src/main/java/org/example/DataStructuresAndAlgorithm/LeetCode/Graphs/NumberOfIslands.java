package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

//https://leetcode.com/problems/number-of-islands/description/
public class NumberOfIslands {
    public void markIslands(int i, int j, char[][] grid, int m, int n, boolean[][] visited) {
        if (i >= m || j >= n || i < 0 || j < 0 || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        markIslands(i + 1, j, grid, m, n, visited);
        markIslands(i - 1, j, grid, m, n, visited);
        markIslands(i, j + 1, grid, m, n, visited);
        markIslands(i, j - 1, grid, m, n, visited);
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int totalIsLands = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    markIslands(i, j, grid, m, n, visited);
                    totalIsLands++;
                }
            }
        }
        return totalIsLands;
    }
}
