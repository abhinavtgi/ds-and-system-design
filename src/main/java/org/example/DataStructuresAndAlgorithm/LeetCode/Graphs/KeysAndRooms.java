package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.List;

//https://leetcode.com/problems/keys-and-rooms/description/
public class KeysAndRooms {
    void canVisit(int i, List<List<Integer>> rooms, boolean[] visited) {
        if(visited[i]) {
            return;
        }
        visited[i]=true;
        for(int j:rooms.get(i)) {
            canVisit(j, rooms, visited);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        canVisit(0, rooms, visited);
        for(boolean i:visited) {
            if(!i) return false;
        }
        return true;
    }
}
