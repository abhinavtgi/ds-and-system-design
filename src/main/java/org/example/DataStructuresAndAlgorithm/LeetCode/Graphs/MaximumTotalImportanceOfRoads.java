package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.PriorityQueue;

//https://leetcode.com/problems/maximum-total-importance-of-roads/description/
public class MaximumTotalImportanceOfRoads {
    public long maximumImportance(int n, int[][] roads) {

        //array to count total neighbors for a city i.e. total roads
        int[] countNeighbours = new int[n];

        //array for importance of each city, city with most road should have max importance for
        //totalImportance to be max
        int[] cityImportance = new int[n];

        //count roads for all the city
        for (int[] i : roads) {
            countNeighbours[i[0]]++;
            countNeighbours[i[1]]++;
        }

        //use pq to get roads with max roads
        PriorityQueue<int[]> p1 = new PriorityQueue<>((a, b)->Integer.compare(b[1],a[1]));

        for(int i=0;i<n;i++) {
            p1.add(new int[]{i, countNeighbours[i]});
        }

        int currentImportance=n;

        //assign imporance to each city based on number of roads
        while(!p1.isEmpty()) {
            int[] current = p1.poll();
            cityImportance[current[0]]=currentImportance;
            currentImportance--;
        }

        long totalImportance=0;

        //now calculate totalimportance for this we will directly check all the roads
        for(int[] i:roads) {
            totalImportance+=cityImportance[i[0]]+cityImportance[i[1]];
        }
        return totalImportance;
    }
}
