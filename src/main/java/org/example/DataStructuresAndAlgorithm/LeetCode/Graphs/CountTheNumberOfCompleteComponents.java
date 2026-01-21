package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/count-the-number-of-complete-components/description/
public class CountTheNumberOfCompleteComponents {
    int numberOfNodes;
    int numberOfEdges;
    void markComponentsAndCountNodesAndEdges(int i, List<List<Integer>> graph, boolean[] visited) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        numberOfNodes++;
        for (int j : graph.get(i)) {
            numberOfEdges++;
            markComponentsAndCountNodesAndEdges(j, graph, visited);
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] i:edges) {
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }

        boolean[] visited = new boolean[n];
        int totalComponents=0;

        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                numberOfNodes=0;
                numberOfEdges=0;
                markComponentsAndCountNodesAndEdges(i,graph,visited);
                int k=numberOfNodes;
                if(numberOfEdges==(k)*(k-1)) {
                    totalComponents++;
                }
            }
        }

        return totalComponents;
    }
}
