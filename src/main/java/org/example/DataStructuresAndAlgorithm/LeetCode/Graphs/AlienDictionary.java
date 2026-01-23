package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.*;

//https://www.geeksforgeeks.org/problems/alien-dictionary/1
public class AlienDictionary {
    public String findOrder(String[] words) {
        // code here
        Map<Character, Set<Character>> wordsGraph = new HashMap<>();
        int[] indegree = new int[26];

        for(int i=0;i<words.length-1;i++) {
            int p1=0;
            int maxP1 = Math.min(words[i].length(), words[i+1].length());
            while(p1<maxP1 && words[i].charAt(p1)==words[i+1].charAt(p1)) {
                p1++;
            }
            if(p1==maxP1 && words[i].length() > words[i+1].length()) {
                return "";
            }
            if(p1<maxP1) {
                char char1=words[i].charAt(p1);
                char char2=words[i+1].charAt(p1);
                Set<Character> temp = wordsGraph.getOrDefault(char1, new HashSet<>());

                if(!temp.contains(char2)) {
                    temp.add(char2);
                    indegree[char2-'a']++;
                }
                wordsGraph.put(char1, temp);
            }
        }

        Set<Character> uniqueCharacters = new HashSet<>();


        for(String i:words) {
            for(int j=0;j<i.length();j++) uniqueCharacters.add(i.charAt(j));
        }

        Queue<Character> q1 = new LinkedList<>();

        for(int i=0;i<26;i++) {
            char key = (char) (i+'a');
            if(indegree[i]==0 && uniqueCharacters.contains(key)) {
                q1.add(key);
            }
        }

        StringBuilder dictionaryOrder = new StringBuilder();

        while(!q1.isEmpty()) {
            char current = q1.poll();
            dictionaryOrder.append(current);

            for(char i:wordsGraph.getOrDefault(current,new HashSet<>())) {
                indegree[i-'a']--;
                if(indegree[i-'a']==0) {
                    q1.add(i);
                }
            }

        }

        return dictionaryOrder.length()!=uniqueCharacters.size() ? "" :dictionaryOrder.toString();
    }
}
