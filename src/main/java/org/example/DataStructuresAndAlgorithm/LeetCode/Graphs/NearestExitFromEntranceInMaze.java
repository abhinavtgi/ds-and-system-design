package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/
public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;
        int[][] directions = {  { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        Queue<int[]> q1 = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        q1.add(new int[]{entrance[0], entrance[1]});
        visited[entrance[0]][entrance[1]]=true;

        int distance=0;

        while(!q1.isEmpty()) {

            int size = q1.size();

            for(int k=0;k<size;k++) {

                int[] current = q1.poll();
                int i=current[0];
                int j=current[1];

                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && maze[i][j] == '.'
                        && (i != entrance[0] || j != entrance[1])) {
                    return distance;
                }


                for(int[] dir:directions) {
                    int newI = i+dir[0];
                    int newJ = j+dir[1];
                    if(newI<0 || newI>=m || newJ<0 || newJ>=n) continue;
                    if(!visited[newI][newJ] && maze[newI][newJ]=='.') {
                        visited[newI][newJ]=true;
                        q1.add(new int[]{newI, newJ});
                    }
                }
            }
            distance++;
        }

        return -1;

    }
}
