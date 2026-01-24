package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.List;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
public class MinimumSpanningTree {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.


        //define pq to inclined towards lower distances
        PriorityQueue<int[]> q1 = new PriorityQueue<>((a, b)->a[1]-b[1]);
        q1.offer(new int[]{0,0});

        //stores the MST sum
        int sum=0;

        //visited array to check if node is visited
        boolean[] visited = new boolean[V];

        while(!q1.isEmpty()) {
            int[] topElement = q1.poll();
            int node = topElement[0];
            int distance = topElement[1];

            if(visited[node]) {
                continue;
            }
            visited[node]=true;
            sum+=distance;

            //go to the neighbour and add all to queue, once all are added
            //we will visit them and update distance
            for(int[] i:adj.get(node)) {
                int neighbour = i[0];
                int neighbourDistance = i[1];
                if(!visited[neighbour]) {
                    q1.add(new int[]{neighbour,neighbourDistance});
                }
            }
        }
        return sum;
    }

}

//Using Kruskal’s Algorithm

//class DisJointSet {
//    int[] size;
//    int[] parent;
//
//    DisJointSet(int n) {
//        size = new int[n];
//        parent = new int[n];
//        for(int i=0;i<n;i++) {
//            size[i]=1;
//            parent[i]=i;
//        }
//    }
//
//    int findUltimateParent(int i) {
//        if(i==parent[i]) {
//            return i;
//        }
//
//        return parent[i]=findUltimateParent(parent[i]);
//    }
//
//    void unionBySize(int i, int j) {
//        int parent1 = findUltimateParent(i);
//        int parent2 = findUltimateParent(j);
//
//        if(parent1==parent2) {
//            return;
//        }
//
//        if(size[parent1]<size[parent2]) {
//            parent[parent1]=parent2;
//            size[parent1]+=size[parent2];
//        }
//        else {
//            parent[parent2]=parent1;
//            size[parent2]+=size[parent1];
//        }
//    }
//}
//
//class Solution {
//    public int spanningTree(int V, int[][] edges) {
//        // code here
//
//        Arrays.sort(edges, (a,b)->Integer.compare(a[2],b[2]));
//
//        DisJointSet ds = new DisJointSet(V);
//
//        int mstSum=0;
//
//        for(int[] i:edges) {
//            int source=i[0];
//            int target=i[1];
//
//
//            if(ds.findUltimateParent(source)!=ds.findUltimateParent(target)) {
//                ds.unionBySize(source,target);
//                mstSum+=i[2];
//            }
//        }
//
//        return mstSum;
//
//
//    }
//}
