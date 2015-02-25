package com.squallsun.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CloneGraphDFS {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hm.put(node, head);

        DFS(hm, node);//DFS
        return head;
    }

    public void DFS(HashMap<UndirectedGraphNode, UndirectedGraphNode> hm, UndirectedGraphNode node) {
        if (node == null) {
            return;
        }

        for (UndirectedGraphNode aneighbor : node.neighbors) {
            if (!hm.containsKey(aneighbor)) {
                UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbor.label);
                hm.put(aneighbor, newneighbor);
                DFS(hm, aneighbor);//DFS
            }
            hm.get(node).neighbors.add(hm.get(aneighbor));
        }
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
