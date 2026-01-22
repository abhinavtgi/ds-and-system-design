package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
public class UndirectedGraphCycle {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<V;i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] i:edges) {
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }

        boolean[] visited = new boolean[V];

        Queue<int[]> q1 = new LinkedList<>();

        for(int k=0;k<V;k++) {
            if(!visited[k]) {
                visited[k]=true;
                q1.add(new int[]{k,-1});
            }

            while(!q1.isEmpty()) {
                int[] topElement = q1.poll();
                int node = topElement[0];
                int parent = topElement[1];

                for(int i:graph.get(node)) {
                    if(!visited[i]) {
                        visited[i]=true;
                        q1.add(new int[]{i, node});
                    }
                    else if(visited[i] && i!=parent) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
