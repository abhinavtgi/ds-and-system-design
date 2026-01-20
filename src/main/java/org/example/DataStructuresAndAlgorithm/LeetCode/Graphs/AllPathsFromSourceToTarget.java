package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/all-paths-from-source-to-target/description/
public class AllPathsFromSourceToTarget {
    List<List<Integer>> allPaths;
    void getAllPaths(int i, int[][] graph, List<Integer> currentPath) {
        if(i==graph.length-1) {
            currentPath.add(i);
            allPaths.add(new ArrayList<>(currentPath));
            currentPath.remove(currentPath.size()-1);
            return;
        }

        currentPath.add(i);

        for(int j: graph[i]) {
            getAllPaths(j, graph, currentPath);
        }
        currentPath.remove(currentPath.size()-1);


    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        allPaths = new ArrayList<>();
        getAllPaths(0, graph, new ArrayList<>());
        return allPaths;
    }
}
