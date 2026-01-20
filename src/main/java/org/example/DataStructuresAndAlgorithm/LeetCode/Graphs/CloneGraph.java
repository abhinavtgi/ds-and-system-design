package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.*;

//https://leetcode.com/problems/clone-graph/description/
public class CloneGraph {
    Map<Node,Node> nodeMapping;

    //dfs to make clone of each node in graph
    void makeCloneNodes(Node root, Set<Node> visited) {
        if(root==null || visited.contains(root)) {
            return;
        }
        nodeMapping.put(root,new Node(root.val));
        visited.add(root);
        for(Node j:root.neighbors) {
            makeCloneNodes(j, visited);
        }
    }

    //dfs to populate the neighbours of cloned nodes
    void cloneGraph(Node root, Set<Node> visited) {
        if(root==null || visited.contains(root)) {
            return;
        }
        visited.add(root);

        //add neighbours for cloneRoot
        Node cloneRoot = nodeMapping.get(root);

        List<Node> cloneNeighbors = new ArrayList<>();

        for(Node j:root.neighbors) {
            cloneNeighbors.add(nodeMapping.get(j));
        }

        cloneRoot.neighbors = cloneNeighbors;

        //visit neighbours of root to add their neighbours also.
        for(Node j:root.neighbors) {
            cloneGraph(j, visited);
        }

    }

    public Node cloneGraph(Node node) {

        nodeMapping = new HashMap<>();
        makeCloneNodes(node, new HashSet<>());

        cloneGraph(node, new HashSet<>());

        return nodeMapping.get(node);
    }
}
