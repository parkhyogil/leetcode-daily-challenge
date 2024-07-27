# [113. Path Sum II](https://leetcode.com/problems/path-sum-ii/description/)

## Intuition
백트래킹 기법으로 문제를 해결한다.
트리를 재귀적으로 순회하여 루트 노드에서 리프 노드까지의 경로를 추적하고, 목표하는 합을 찾았다면 추적한 경로를 추가한다. 
그렇지 않다면 재귀 함수를 종료하면서 추적한 경로를 제거하며 답을 찾는다.

## Algorithm
- 재귀함수를 정의한다.
  - `TreeNode node` : 현재 노드
  - `int sum` : 루트 노드에서 현재 노드까지의 합
  - `int targetSum` : 목표 합
  - `List<Integer> path` : 루트 노드에서 현재 노드까지의 경로
  - `List<List<Integer>> res` : 루트 노드에서 리프 노드까지의 합이 목표 합과 같은 경로를 저장할 리스트
  - 재귀함수의 동작 순서
    1. 현재 위치한 노드가 `null`이면 재귀함수를 종료한다.
    2. `sum`와 `path`에 현재 노드의 값을 추가한다.
    3. 현재 위치한 노드가 리프 노드이고 현재 합이 목표 합과 같다면 `res`에 `path`를 추가한다. 그렇지 않다면 현재 노드의 자식 노드로 재귀함수를 호출한다.
    4. `path`에서 현재 노드를 제거한다.
1. 경로를 저장할 `res`를 초기화하고 루트 노드에서 재귀함수를 호출한다.
2. `res`를 리턴한다.

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();

        recur(root, 0, targetSum, new ArrayList<>(), res);

        return res;
    }

    private void recur(TreeNode node, int sum, int targetSum, List<Integer> path, List<List<Integer>> res) {
        if (node == null) {
            return;
        }

        sum += node.val;
        path.add(node.val);

        if (isLeafNode(node)) {
            if (sum == targetSum) {
                res.add(new ArrayList<>(path));
            }
        } else {
            recur(node.left, sum, targetSum, path, res);
            recur(node.right, sum, targetSum, path, res);
        }

        path.remove(path.size() - 1);
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
```

## Complexity
`n`은 트리 노드의 개수
- Time complexity: O(n)
- Space complexity: O(n)
