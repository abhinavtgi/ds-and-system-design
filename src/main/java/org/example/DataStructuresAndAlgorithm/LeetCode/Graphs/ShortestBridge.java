package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.*;

//https://leetcode.com/problems/shortest-bridge/
public class ShortestBridge {
    static final int[][] directions = {{0,1},{1,0},{0,-1}, {-1,0}};

    //visit all nodes in an island and add them to queue
    void markFirstIsland(int i, int j, int[][]  grid, int m, int n, boolean[][] visited, Queue<int[]> q1) {
        if(i>=m || i<0 || j>=n || j<0 || grid[i][j]==0 || visited[i][j]) {
            return;
        }
        q1.add(new int[]{i,j});
        visited[i][j]=true;

        for(int[] dir:directions) {
            int newI = i+dir[0];
            int newJ = j+dir[1];
            markFirstIsland(newI,newJ,grid,m,n,visited,q1);
        }

    }

    //idea is to get all nodes of one island in a queue and start bfs from each node and reach
    //level by level further, whenever we reach 2nd island that will be min distance
    //because we are moving level by level so return
    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q1 = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        boolean isFound=false;

        //visit all nodes of one island and  add them to queue, no need to mark as 2 since we will be
        //using same visited array
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1) {
                    markFirstIsland(i,j,grid,m,n,visited,q1);
                    isFound=true;
                    break;
                }
            }
            if(isFound) break;
        }

        int distance=0;

        //now move from each node to its neighbour and keep incrementing distance after each level
        while(!q1.isEmpty()) {
            int size = q1.size();
            for(int k=0;k<size;k++) {
                int[] current = q1.poll();
                int i = current[0];
                int j = current[1];

                //visit neighbours
                for(int[] dir:directions) {
                    int newI = i+dir[0];
                    int newJ = j+dir[1];

                    //out of bounds
                    if(newI<0 || newI>=m || newJ<0 || newJ>=n) {
                        continue;
                    }

                    //it should not be visited otherwise its 1st island
                    if(!visited[newI][newJ] && grid[newI][newJ]==1) {
                        return distance;
                    }

                    //only add 0s to queue since when we add one we will get the 2nd island
                    //also nodes of one island are already visited so they are marked as visited
                    if(!visited[newI][newJ] && grid[newI][newJ]==0) {
                        q1.add(new int[]{newI, newJ});
                        visited[newI][newJ]=true;
                    }
                }
            }
            distance++;
        }

        //can't reach 2nd island, this is never possible according to inputs given
        return -1;
    }
}
