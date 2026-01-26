package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/critical-connections-in-a-network/description/
public class CriticalConnectionsInANetwork {
    void getBridgesInNetwork(int i, int parent, List<List<Integer>> graph, boolean[] visited, int[] lowestTime,
                             int[] discoveryTime, int currentTime, List<List<Integer>> criticalEdges) {
        visited[i] = true;
        lowestTime[i] = currentTime;
        discoveryTime[i] = currentTime;
        currentTime++;

        for (int j : graph.get(i)) {
            if (j == parent)
                continue;

            if (!visited[j]) {
                getBridgesInNetwork(j, i, graph, visited, lowestTime, discoveryTime, currentTime, criticalEdges);
                lowestTime[i] = Math.min(lowestTime[i], lowestTime[j]);
                if (lowestTime[j] > discoveryTime[i]) {
                    criticalEdges.add(Arrays.asList(i, j));
                }
                lowestTime[i] = Math.min(lowestTime[i], lowestTime[j]);
            } else {
                lowestTime[i] = Math.min(lowestTime[i], lowestTime[j]);
            }
        }

    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> con : connections) {
            graph.get(con.get(0)).add(con.get(1));
            graph.get(con.get(1)).add(con.get(0));
        }

        List<List<Integer>> criticalEdges = new ArrayList<>();

        getBridgesInNetwork(0, -1, graph, new boolean[n], new int[n], new int[n], 0, criticalEdges);

        return criticalEdges;

    }
}
