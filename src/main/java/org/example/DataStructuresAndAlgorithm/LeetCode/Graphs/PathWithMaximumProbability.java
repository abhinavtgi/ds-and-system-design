package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.*;

//https://leetcode.com/problems/path-with-maximum-probability/description/
public class PathWithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        List<List<double[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }

        int index=0;
        for(int[] i:edges) {
            graph.get(i[0]).add(new double[]{i[1], succProb[index]});
            graph.get(i[1]).add(new double[]{i[0], succProb[index++]});
        }

        PriorityQueue<double[]> q1 = new PriorityQueue<>((a,b)->Double.compare(b[1],a[1]));

        double[] probabilitiesArray = new double[n];
        Arrays.fill(probabilitiesArray, 0);

        q1.add(new double[]{start_node, 1});

        while(!q1.isEmpty()) {
            double[] current = q1.poll();

            int node = (int) current[0];

            double probability = current[1];

            if(probability<probabilitiesArray[node]) {
                continue;
            }

            for(double[] i:graph.get(node)) {
                int newNode = (int) i[0];

                double newProbabilty = probability*i[1];
                if(newProbabilty>probabilitiesArray[newNode]) {
                    q1.add(new double[]{newNode, newProbabilty});
                    probabilitiesArray[newNode]=newProbabilty;
                }
            }
        }
        return probabilitiesArray[end_node];
    }
}
