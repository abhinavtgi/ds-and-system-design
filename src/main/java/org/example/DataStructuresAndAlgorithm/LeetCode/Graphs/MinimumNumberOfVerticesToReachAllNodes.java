package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/
public class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        int[] indegree = new int[n];

        for(List<Integer> i:edges) {
            indegree[i.get(1)]++;
        }

        List<Integer> startNodes = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(indegree[i]==0) {
                startNodes.add(i);
            }
        }

        return startNodes;
    }
}
