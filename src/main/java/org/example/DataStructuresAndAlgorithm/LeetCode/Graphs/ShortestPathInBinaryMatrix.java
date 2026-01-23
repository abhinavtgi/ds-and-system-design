package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
public class ShortestPathInBinaryMatrix {
    static final int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { 1, -1 },
            { -1, 1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        Queue<int[]> q1 = new LinkedList<>();
        int[][] distancesMatrix = new int[n][n];

        for (int[] i : distancesMatrix)
            Arrays.fill(i, Integer.MAX_VALUE);

        if (grid[0][0] == 0) {
            q1.add(new int[] { 0, 0, 0 });
            distancesMatrix[0][0] = 0;
        }

        while (!q1.isEmpty()) {
            int[] current = q1.poll();
            int i = current[0];
            int j = current[1];
            int distance = current[2];

            if (i == n - 1 && j == n - 1) {
                return distancesMatrix[n - 1][n - 1] + 1;
            }

            if (distance > distancesMatrix[i][j]) {
                continue;
            }

            for (int[] dir : directions) {
                int newI = i + dir[0];
                int newJ = j + dir[1];
                if (newI < 0 || newI >= n || newJ < 0 || newJ >= n)
                    continue;
                if (distance + 1 < distancesMatrix[newI][newJ] && grid[newI][newJ] == 0) {
                    q1.add(new int[] { newI, newJ, distance + 1 });
                    distancesMatrix[newI][newJ] = distance + 1;
                }
            }

        }

        int distanceLastNode = distancesMatrix[n - 1][n - 1];

        return distanceLastNode == Integer.MAX_VALUE ? -1 : distanceLastNode + 1;
    }
}
