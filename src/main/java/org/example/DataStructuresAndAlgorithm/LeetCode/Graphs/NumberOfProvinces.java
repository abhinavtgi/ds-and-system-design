package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

//https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);

        //iterate and where isConnected[i][j]==1 that means there is an edge b/w i and j, so do
        //the unionBySize
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(isConnected[i][j]==1) {
                    ds.unionBySize(i,j);
                }
            }
        }

        //we can get total components by find all the root nodes, a root node is the one
        //which is its own parent
        int totalComponents = 0;

        for(int i=0;i<n;i++) {
            if(ds.findUltimateParent(i)==i) {
                totalComponents++;
            }
        }
        return totalComponents;
    }
// BFS approach
//    public int findCircleNum(int[][] isConnected) {
//        int n = isConnected.length;
//        boolean[] visited = new boolean[n];
//        int numberOfProvince = 0;
//
//        Queue<Integer> q1 = new LinkedList<>();
//
//        for(int k=0;k<n;k++) {
//            if(!visited[k]) {
//                q1.add(k);
//                visited[k]=true;
//                numberOfProvince++;
//            }
//
//            while(!q1.isEmpty()) {
//                int i = q1.poll();
//
//                for(int j=0;j<isConnected.length;j++) {
//                    if(isConnected[i][j]==1 && !visited[j]) {
//                        q1.add(j);
//                        visited[j]=true;
//                    }
//                }
//            }
//
//        }
//
//        return numberOfProvince;
//    }
//
// DFS approach
//    void markProvince(int i, int[][] isConnected, boolean[] visited) {
//        if (visited[i]) {
//            return;
//        }
//
//        visited[i] = true;
//
//        for (int j=0;j<isConnected.length;j++) {
//            if (isConnected[i][j] == 1) {
//                markProvince(j, isConnected, visited);
//            }
//        }
//    }
//
//    public int findCircleNum(int[][] isConnected) {
//        int n = isConnected.length;
//        boolean[] visited = new boolean[n];
//        int numberOfProvince = 0;
//
//        for (int i = 0; i < n; i++) {
//            if (!visited[i]) {
//                markProvince(i, isConnected, visited);
//                numberOfProvince++;
//            }
//        }
//
//        return numberOfProvince;
//    }
}
