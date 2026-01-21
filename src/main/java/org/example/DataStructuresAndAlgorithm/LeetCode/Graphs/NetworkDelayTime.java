package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/network-delay-time/description/
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> nodeGraph = new ArrayList<>();

        //n nodes in graph
        for(int i=0;i<n;i++) {
            nodeGraph.add(new ArrayList<>());
        }

        //nodes are 1 to n so normalize it to 0 to n-1 by adding -1
        for(int[]i:times) {
            nodeGraph.get(i[0]-1).add(new int[]{i[1]-1,i[2]});
        }

        int[] timeToReachNode = new int[n];

        Arrays.fill(timeToReachNode, Integer.MAX_VALUE);

        PriorityQueue<int[]> q1 = new PriorityQueue<>((a, b)->Integer.compare(a[1],b[1]));

        //start with kth node, adding -1 to normalize
        q1.add(new int[]{k-1,0});
        timeToReachNode[k-1]=0;

        while(!q1.isEmpty()) {
            int[] current = q1.poll();
            int currentDistance = current[1];

            for(int[] i:nodeGraph.get(current[0])) {
                int neighbor = i[0];
                int distance = i[1];

                //update only if its better path
                if(currentDistance+distance<timeToReachNode[neighbor]) {
                    timeToReachNode[neighbor]=currentDistance+distance;
                    q1.add(new int[]{neighbor, timeToReachNode[neighbor]});
                }
            }
        }

        int maxTime=0;

        //check max time that will be the time to reach all nodes
        for(int i:timeToReachNode) {

            //node was unreached so return -1
            if(i==Integer.MAX_VALUE) {
                return -1;
            }
            maxTime=Math.max(maxTime,i);
        }

        return maxTime;

    }
}
