package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/01-matrix/description/
public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q1 = new LinkedList<>();

        int[][] newMat = new int[m][n];

        for (int[] i : newMat) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q1.add(new int[] { i, j });
                    newMat[i][j] = 0;
                }
            }
        }

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!q1.isEmpty()) {
            int[] current = q1.poll();
            int i = current[0];
            int j = current[1];
            int distance = newMat[i][j];

            for (int[] dir : directions) {
                if(i+dir[0]<0 || i+dir[0]>=m || j+dir[1]<0 || j+dir[1]>=n) {
                    continue;
                }
                if (mat[i + dir[0]][j + dir[1]] == 1) {
                    int newDistance = 1 + distance;
                    if (newDistance < newMat[i + dir[0]][j + dir[1]]) {
                        q1.add(new int[] { i + dir[0], j + dir[1] });
                        newMat[i + dir[0]][j + dir[1]] = newDistance;
                    }
                }
            }

        }
        return newMat;
    }
}
