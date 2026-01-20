package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/description/
public class RottingOranges {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q1 = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int freshOrangesCount=0;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==2) {
                    q1.add(new int[]{i,j});
                }
                if(grid[i][j]==1) {
                    freshOrangesCount++;
                }
            }
        }

        if(freshOrangesCount==0) {
            return 0;
        }

        int time=0;

        while(!q1.isEmpty()) {
            int size = q1.size();

            for(int k=0;k<size;k++) {
                int[] current = q1.poll();
                int i = current[0];
                int j=current[1];

                if(i+1<m && grid[i+1][j]==1) {
                    grid[i+1][j]=2;
                    q1.add(new int[]{i+1,j});
                    freshOrangesCount--;
                }
                if(i-1>=0 && grid[i-1][j]==1) {
                    grid[i-1][j]=2;
                    q1.add(new int[]{i-1,j});
                    freshOrangesCount--;
                }
                if(j+1<n && grid[i][j+1]==1) {
                    grid[i][j+1]=2;
                    q1.add(new int[]{i,j+1});
                    freshOrangesCount--;
                }
                if(j-1>=0 && grid[i][j-1]==1) {
                    grid[i][j-1]=2;
                    q1.add(new int[]{i,j-1});
                    freshOrangesCount--;
                }
            }

            time++;
        }

        return freshOrangesCount==0 ?  time-1 : -1;

    }
}
