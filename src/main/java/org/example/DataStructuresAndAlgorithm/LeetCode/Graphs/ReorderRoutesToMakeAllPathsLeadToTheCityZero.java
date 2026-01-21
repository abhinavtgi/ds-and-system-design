package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] i : connections) {
            //real edge
            graph.get(i[0]).add(new int[]{i[1], 1});
            //reversed edge
            graph.get(i[1]).add(new int[]{i[0], -1});
        }

        int changesNeeded=0;

        Queue<Integer> q1 = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q1.add(0);
        visited[0]=true;

        //start from 0 and check if its neighbour can reach it
        //then check neighbours neighbour if they can reach neighbour and so on
        while(!q1.isEmpty()) {

            int current = q1.poll();

            for(int[] i:graph.get(current)) {
                //from 0 we want inward edge so if we have real edge from 0 to neighbour that means
                //its outgoing edge and we need to reverse it
                //also we dont want this neighbour to be visited because since we have both the edges
                //we will come to the node again which we have already checked
                //eg consider graph is 2->1->0 once we check for 0 and then we come to 1
                //then its neighbour 0 has outgoing edge so it will increment changesNeeded
                //but we have actually checked 0 already and 1->0 means we will go to 0
                //so we need visited check here
                if(i[1]==1 && !visited[i[0]]) {
                    changesNeeded++;
                }
                if(!visited[i[0]]) {
                    q1.add(i[0]);
                    visited[i[0]]=true;
                }
            }
        }

        return changesNeeded;

    }
}
