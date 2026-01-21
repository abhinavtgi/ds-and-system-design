package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-groups-of-farmland/description/
public class FindAllGroupsOfFarmland {
    int startX;
    int startY;
    int endX;
    int endY;

    void markFarmLands(int i, int j, int[][] land, int m, int n) {
        if (i >= m || i < 0 || j >= n || j < 0 || land[i][j] == 0) {
            return;
        }
        land[i][j] = 0;
        startX = Math.min(startX, i);
        startY = Math.min(startY, j);
        endX = Math.max(endX, i);
        endY = Math.max(endY, j);
        markFarmLands(i + 1, j, land, m, n);
        markFarmLands(i - 1, j, land, m, n);
        markFarmLands(i, j+1, land, m, n);
        markFarmLands(i, j-1, land, m, n);
    }

    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;

        List<int[]> farms = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    startX = m;
                    startY = n;
                    endX = -1;
                    endY = -1;
                    markFarmLands(i, j, land, m, n);
                    farms.add(new int[] { startX, startY, endX, endY });
                }
            }
        }

        return farms.toArray(new int[farms.size()][]);

    }
}
