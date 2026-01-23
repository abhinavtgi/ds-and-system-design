package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.*;

//https://leetcode.com/problems/minimum-height-trees/description/
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] i:edges) {
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
            indegree[i[1]]++;
            indegree[i[0]]++;
        }

        //idea is to add all leaf nodes in queue and move next level that is another nodes becomes leaf
        //so we do that will we reach middle. Adding leaf nodes like that so that we reach mid and have
        //min height, this is the crux
        Queue<Integer> q1 = new LinkedList<>();

        for(int i=0;i<n;i++) {
            //add leaf nodes to queue
            if(indegree[i]==1) {
                q1.add(i);
            }
        }

        List<Integer> minHeightNodes = new ArrayList<>();

        int numberOfNodesLeft=n;

        //do this till we have 2 or less nodes present because they will be mid
        while(numberOfNodesLeft>2) {
            int size=q1.size();
            numberOfNodesLeft-=size;

            for(int k=0;k<size;k++) {
                int current = q1.poll();

                for(int i:graph.get(current)) {
                    indegree[i]--;
                    //if these neighbors become leaf nodes so add them
                    if(indegree[i]==1) {
                        q1.add(i);
                    }
                }
            }

        }

        while(!q1.isEmpty()) {
            minHeightNodes.add(q1.poll());
        }

        //edge case: when only one node so no edges and queue is empty
        if(n==1) {
            minHeightNodes.add(0);
        }

        return minHeightNodes;

    }
}
