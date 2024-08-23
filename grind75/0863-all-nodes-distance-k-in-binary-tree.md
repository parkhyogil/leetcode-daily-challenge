# [863. All Nodes Distance K in Binary Tree](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/)

## Intuition
트리를 그래프처럼 순회하기 위해 자식 노드에서 부모 노드로 갈 수 있는 간선을 만들고, 타겟 노드에서 `k` 거리에 있는 노드를 찾는다.

## Algorithm
1. `findParentNode` 메소드를 호출하여 트리를 순회하며 자식 노드의 부모 노드를 `parentNodeMap`에 저장한다.
2. `List<Integer> result`를 초기화하고 `traverseDistanceK` 메소드를 호출해 타겟 노드에서 `k` 거리 떨어져 있는 노드의 값을 저장한다.
3. `result`를 반환한다.

## Implementation
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentNodeMap = new HashMap<>();
        findParentNode(root, null, parentNodeMap);

        List<Integer> result = new ArrayList<>();

        traverseDistanceK(target, k, parentNodeMap, result, new boolean[501]);

        return result;
    }

    private void traverseDistanceK(TreeNode node, int k, Map<TreeNode, TreeNode> parentNodeMap, List<Integer> values, boolean[] visit) {
        if (node == null || visit[node.val]) {
            return;
        }

        visit[node.val] = true;

        if (k == 0) {
            values.add(node.val);
            return;
        }

        traverseDistanceK(node.left, k - 1, parentNodeMap, values, visit);
        traverseDistanceK(node.right, k - 1, parentNodeMap, values, visit);
        traverseDistanceK(parentNodeMap.get(node), k - 1, parentNodeMap, values, visit);
    }

    private void findParentNode(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentNodeMap) {
        if (node == null) {
            return;
        }

        parentNodeMap.put(node, parent);

        findParentNode(node.left, node, parentNodeMap);
        findParentNode(node.right, node, parentNodeMap);
    }
}
```

## Complexity
`n`은 트리 노드 개수
- Time complexity: O(n)
- Space complexity: O(n)
