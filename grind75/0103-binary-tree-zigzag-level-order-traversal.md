# [103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/)

## Intuition
트리를 순회하면서 각 노드의 레벨을 기준으로 노드의 값을 리스트의 앞쪽이나 뒤쪽에 추가한다.

## Algorithm
- `zigzagLevelOrder` 메소드 : 주어진 트리의 각 레벨을 지그재그 방식으로 탐색하여, 레벨별 값을 리스트에 저장한 후 리턴한다.
  1. `List<List<Integer>> result`를 초기화한다.
  2. `traverseTree` 메소드를 호출하여 트리를 순회한다.
  3. `result`를 리턴한다.
- `traverseTree` 메소드 : 트리를 순회하며 노드의 값을 레벨에 맞는 리스트에 추가한다.
  1. `node == null`이면 재귀 호출을 종료한다.
  2. `result`에 현재 레벨의 리스트가 없으면 새로운 리스트를 추가한다.
  3. 현재 레벨이 짝수면 노드의 값을 리스트의 뒤에 추가하고, 홀수면 리스트의 앞에 추가한다.
  4. 자식 노드로 재귀적으로 탐색을 이어간다.

## Implementation
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        traverseTree(root, 0, result);

        return result;
    }

    private void traverseTree(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        if (result.size() == level) {
            result.add(new LinkedList<>());
        }

        if (level % 2 == 0) {
            result.get(level).addLast(node.val);
        } else {
            result.get(level).addFirst(node.val);
        }

        traverseTree(node.left, level + 1, result);
        traverseTree(node.right, level + 1, result);
    }
}
```

## Complexity
`n`은 트리 노드의 개수
- Time complexity: O(n)
- Space complexity: O(n)
