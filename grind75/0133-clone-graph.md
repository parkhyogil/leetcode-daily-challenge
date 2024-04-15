# [133. Clone Graph](https://leetcode.com/problems/clone-graph/description/)

## Intuition
DFS 기법으로 그래프를 순회하면서 맵을 이용해 노드의 값을 키로, 복사한 노드를 값으로 저장한다.
그리고 인접한 노드를 연결한다.

## Algorithm
1. 원본 노드 값을 키, 복사된 노드를 값으로 하는 `map`을 선언.
2. `clone()` 메소드로 복사된 노드를 리턴.    
2.1. 방문한 노드라면 `map`에 저장된 복사한 노드를 리턴.    
2.2. 처음 방문한 노드라면 노드를 복사하고 `map`에 저장.    
2.3. 원본 노드의 인접한 노드들을 `clone()` 메소드로 복사하고 현재 복사된 노드의 `neighbors`에 저장.    
2.4. 복사된 노드를 리턴.

## Implementation
```java
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

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Integer, Node> map = new HashMap<>();

        return clone(node, map);
    }

    private Node clone(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node copy = new Node(node.val);
        map.put(node.val, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(clone(neighbor, map));
        }

        return copy;
    }
}
```

## Complexity
- Time complexity: O(n)   
복사를 위해 그래프를 한번 순회한다. `n`은 그래프 노드의 개수.

- Space complexity: O(n)   
`map`에 복사한 노드를 저장한다. `n`은 그래프 노드의 개수.
