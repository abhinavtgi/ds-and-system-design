package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/description/
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<List<Integer>> courseGraph = new ArrayList<>();

        for(int i=0;i<numCourses;i++) {
            courseGraph.add(new ArrayList<>());
        }

        for(int[] i:prerequisites) {
            indegree[i[0]]++;
            courseGraph.get(i[1]).add(i[0]);
        }

        Queue<Integer> q1 = new LinkedList<>();

        for(int i=0;i<indegree.length;i++) {
            if(indegree[i]==0) {
                q1.add(i);
            }
        }

        int[] courseOrder = new int[numCourses];
        int index=0;

        int courseCompleted=0;

        while(!q1.isEmpty()) {
            int current = q1.poll();
            courseOrder[index++]=current;
            courseCompleted++;
            for(int i:courseGraph.get(current)) {
                indegree[i]--;
                if(indegree[i]==0) {
                    q1.add(i);
                }
            }
        }

        return courseCompleted==numCourses ? courseOrder : new int[0];
    }
}
