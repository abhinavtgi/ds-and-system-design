package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-eventual-safe-states/description/
public class FindEventualSafeStates {
    boolean dfsDetectCycle(int i, int[][] graph, boolean[] visited, boolean[] pathVisited, boolean[] safeNodesCheck) {
        visited[i] = true;
        pathVisited[i] = true;
        for (int j : graph[i]) {
            if (!visited[j]) {
                boolean isCycle = dfsDetectCycle(j, graph, visited, pathVisited, safeNodesCheck);
                if(isCycle) {
                    return true;
                }
            } else if (visited[j] && pathVisited[j]) {
                return true;
            }
        }
        safeNodesCheck[i] = true;
        pathVisited[i] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        boolean[] safeNodesCheck = new boolean[n];

        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsDetectCycle(i, graph, visited, pathVisited, safeNodesCheck);
            }
        }

        for (int i = 0; i < n; i++) {
            if (safeNodesCheck[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}
