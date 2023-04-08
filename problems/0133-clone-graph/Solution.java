class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return dfs(node, new HashMap<>());
    }

    private Node dfs(Node node, Map<Integer, Node> map) {
        int val = node.val;
        if (map.containsKey(val)) {
            return map.get(val);
        }

        Node clone = new Node(val);
        map.put(val, clone);

        for (Node child : node.neighbors) {
            clone.neighbors.add(dfs(child, map));
        }
        return clone;
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
