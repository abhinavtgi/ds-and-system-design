package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
public class CheapestFlightsWithinKStops {
    static final int INF = 1_000_000;
    int cheapestFlightWithKStops(int i, List<List<int[]>> flightsGraph, int dst, int k, int[][] cheapestFlightMemo) {
        if (k < 0) {
            return INF;
        }
        if (i == dst && k >= 0) {
            return 0;
        }

        if (cheapestFlightMemo[i][k] != -1) {
            return cheapestFlightMemo[i][k];
        }

        int minCost = INF;

        for (int[] j : flightsGraph.get(i)) {
            int cost = j[1] + cheapestFlightWithKStops(j[0], flightsGraph, dst, k - 1, cheapestFlightMemo);
            minCost = Math.min(minCost, cost);
        }

        return cheapestFlightMemo[i][k] = minCost;

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> flightsGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            flightsGraph.add(new ArrayList<>());
        }

        for (int[] i : flights) {
            flightsGraph.get(i[0]).add(new int[] { i[1], i[2] });
        }

        int[][] cheapestFlightMemo = new int[n][k + 2];
        for (int[] i : cheapestFlightMemo) {
            Arrays.fill(i, -1);
        }

        int minCost = cheapestFlightWithKStops(src, flightsGraph, dst, k + 1, cheapestFlightMemo);

        return minCost == INF ? -1 : minCost;

    }
}
