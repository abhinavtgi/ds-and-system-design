package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
public class DirectedGraphCycle {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        int[] indegree = new int[V];

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<V;i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] i:edges) {
            graph.get(i[0]).add(i[1]);
            indegree[i[1]]++;
        }

        Queue<Integer> q1 = new LinkedList<>();

        for(int i=0;i<V;i++){
            if(indegree[i]==0) {
                q1.add(i);
            }
        }

        int nodesCompleted=0;

        while(!q1.isEmpty()) {
            int current = q1.poll();
            nodesCompleted++;

            for(int i:graph.get(current)) {
                indegree[i]--;
                if(indegree[i]==0) {
                    q1.add(i);
                }
            }
        }

        return nodesCompleted!=V;
    }

}
