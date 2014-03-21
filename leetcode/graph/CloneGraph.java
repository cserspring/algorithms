package graph;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null)
            return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> createdMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        Queue<UndirectedGraphNode> queue = new ArrayDeque<UndirectedGraphNode>();
        queue.add(node);
        UndirectedGraphNode rootNode = new UndirectedGraphNode(node.label);
        createdMap.put(node, rootNode);
        while (!queue.isEmpty()) {
            node = queue.remove();
            UndirectedGraphNode clonedNode = createdMap.get(node);
            for (int i = 0; i < node.neighbors.size(); ++i) {
                UndirectedGraphNode tmpNode = node.neighbors.get(i);
                if (!createdMap.containsKey(tmpNode)) {
                    UndirectedGraphNode newNode = new UndirectedGraphNode(
                            tmpNode.label);
                    createdMap.put(tmpNode, newNode);
                    queue.add(tmpNode);
                    clonedNode.neighbors.add(newNode);
                } else {
                    clonedNode.neighbors.add(createdMap.get(tmpNode));
                }
            }
        }
        return rootNode;
    }
}