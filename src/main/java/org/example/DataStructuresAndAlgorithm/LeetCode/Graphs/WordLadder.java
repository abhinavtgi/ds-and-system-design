package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.*;

//https://leetcode.com/problems/word-ladder/description/
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> q1 = new LinkedList<>();
        Set<String> wordsSet = new HashSet<>(wordList);
        int level=0;

        Set<String> visited = new HashSet<>();

        q1.add(beginWord);
        visited.add(beginWord);

        while(!q1.isEmpty()){
            int size = q1.size();
            level++;
            for(int k=0;k<size;k++) {
                String current = q1.poll();
                if(current.equals(endWord)) {
                    return level;
                }
                for(int i=0;i<current.length();i++) {
                    for(int j=0;j<26;j++) {
                        char c = (char) (j+'a');
                        String newS = current.substring(0,i)+c+current.substring(i+1,current.length());
                        // System.out.println("current= "+current+" newS= "+newS);
                        if(wordsSet.contains(newS) && !visited.contains(newS)) {
                            // System.out.println("added to queue= "+newS);
                            q1.add(newS);
                            visited.add(newS);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
