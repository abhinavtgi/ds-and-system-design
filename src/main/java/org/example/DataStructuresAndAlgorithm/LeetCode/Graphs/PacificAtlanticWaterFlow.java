package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/pacific-atlantic-water-flow/description/
public class PacificAtlanticWaterFlow {
    void checkFlow(int i, int j, int[][] heights, boolean[][] canFlow, int m, int n) {
        if (i >= m || i < 0 || j >= n || j < 0 || canFlow[i][j]) {
            return;
        }
        canFlow[i][j] = true;
        if (i + 1 < m && heights[i + 1][j] >= heights[i][j]) {
            checkFlow(i + 1, j, heights, canFlow, m, n);
        }

        if (j + 1 < n && heights[i][j + 1] >= heights[i][j]) {
            checkFlow(i, j + 1, heights, canFlow, m, n);
        }

        if (i - 1 >= 0 && heights[i - 1][j] >= heights[i][j]) {
            checkFlow(i - 1, j, heights, canFlow, m, n);
        }

        if (j - 1 >= 0 && heights[i][j - 1] >= heights[i][j]) {
            checkFlow(i, j - 1, heights, canFlow, m, n);
        }

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] canFlowPacific = new boolean[m][n];
        boolean[][] canFlowAtlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            checkFlow(i, 0, heights, canFlowPacific, m, n);
            checkFlow(i, n - 1, heights, canFlowAtlantic, m, n);
        }

        for (int j = 0; j < n; j++) {
            checkFlow(0, j, heights, canFlowPacific, m, n);
            checkFlow(m - 1, j, heights, canFlowAtlantic, m, n);
        }

        List<List<Integer>> canFlowPacificAtlantic = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canFlowPacific[i][j] && canFlowAtlantic[i][j]) {
                    canFlowPacificAtlantic.add(Arrays.asList(i, j));
                }
            }
        }

        return canFlowPacificAtlantic;
    }
}
