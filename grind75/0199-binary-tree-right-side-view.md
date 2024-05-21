# [199. Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)

## Intuition
재귀함수를 호출할 때 노드의 오른쪽부터 호출해서 현재 깊이를 처음 방문한 오른쪽 노드일 때 결과에 노드값을 저장.

## Algorithm
1. 결과를 저장할 `res`와 `depth`를 `0`으로 재귀함수를 호출.
   1. `root`가 `null`이라면 재귀함수를 종료.
   2. `res.size() == depth`라면 현재 깊이를 처음 방문한 오른쪽 노드이기 때문에 `res`에 노드값을 저장.
   3. 노드의 오른쪽 자식부터 재귀함수를 호출.
2. `res` 리턴.

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        recur(0, root, res);

        return res;
    }

    private void recur(int depth, TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (res.size() == depth) {
            res.add(root.val);
        }

        recur(depth + 1, root.right, res);
        recur(depth + 1, root.left, res);
    }
}
```

## Complexity
`n`은 트리 노드 개수.
- Time complexity: O(n)\
트리를 한번 순회.

- Space complexity: O(n)\
재귀함수의 깊이는 최대 트리 노드 개수.
