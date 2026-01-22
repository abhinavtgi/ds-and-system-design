package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/is-graph-bipartite/description/
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        //queue contains node and its set, set is either 1 or -1 as we have only 2 sets
        Queue<int[]> q1 = new LinkedList<>();

        boolean[] visited = new boolean[n];

        //store which set each node belongs to
        int[] nodeSet = new int[n];

        //start bfs from all nodes because graph can be unconnected
        for(int k=0;k<n;k++) {

            if(!visited[k]) {
                q1.add(new int[]{k,1});
                visited[k]=true;
            }


            while(!q1.isEmpty()) {
                int[] current = q1.poll();
                int node = current[0];
                int currentNodeSet = current[1];
                nodeSet[node] = currentNodeSet;

                for(int i:graph[node]) {

                    //if not yet visited then visit and add to complementary set
                    if(!visited[i]) {
                        visited[i]=true;
                        q1.add(new int[]{i,-1*currentNodeSet});
                    }

                    //if visited and set is same as neighbour then we need to return false
                    else if(visited[i] && nodeSet[i]==currentNodeSet) {
                        return false;
                    }
                }
            }
        }

        return true;


    }
}
