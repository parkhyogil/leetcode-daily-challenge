# [98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)

## Intuition
이진탐색 트리의 왼쪽 서브트리는 루트 값보다 작아야하고 오른쪽 서브트리는 루트 값보다 커야한다.\
재귀함수로 루트의 값을 내려줘서 검증한다.

## Algorithm
1. 루트가 `null` 이라면 `true`, 루트 값이 최소값과 최대값 범위 밖이라면 `false`를 리턴.
2. 왼쪽 서브 트리는 최대값에 루트 값을, 오른쪽 서브 트리는 최소값에 루트 값을 넣어 재귀함수를 호출한다.

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
    public boolean isValidBST(TreeNode root) {
        return recur(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean recur(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return recur(root.left, min, root.val) && recur(root.right, root.val, max);
    }
}
```

## Complexity
- Time complexity: O(n)\
트리 순회에 사용한 시간. `n`은 노드의 개수.
- Space complexity: O(h)\
재귀함수에서 사용한 콜스택 공간. `h`는 트리의 깊이. 최대 깊이는 노드의 개수가 될 수 있다.
