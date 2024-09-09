# [124. Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/description/)

## Intuition
임의의 노드를 루트로 하는 서브트리에서 최대 경로 합은 현재 노드의 값과 양쪽 자식 노드를 각각 루트로 하는 서브트리에서 한쪽 자식 노드만 선택한 경로의 합이다.
이후, 부모 노드에서 동일한 계산을 수행하기 위해, 현재 노드의 값과 양쪽 자식 노드에서 계산한 경로 합 중 최댓값을 더한 값을 반환한다.


예를 들어, 아래와 같은 트리가 주어졌을 때:
```
   20
 /    \
9      -3
     /    \
    15     7
```
리프 노드에서는 계산할 경로가 없으므로 각 노드의 값을 반환한다.
```
   -3               selected path =>    -3
 /    \                               /    
15     7                             15       
```
`-3`을 루트 노드로 하는 서브 트리에서 최대 경로 합은 `-3 + 15 + 7`이 된다. 그리고 부모 노드에서 사용할 경로는 `-3 -> 15`를 선택한다.
```
   20               selected path =>    20
 /    \                                    \
9      -3                                   -3
     /                                    /
    15                                   15
```
`20`을 루트 노드로 하는 서브 트리에서 최대 경로 합은 `20 + 9 + (-3) + 15`이 된다. 그리고 부모 노드에서 사용할 경로는 `20 -> -3 -> 15`를 선택한다.


계산 순서가 양쪽 자식 노드를 먼저 계산하고 그 결과를 사용해 현재 노드를 계산하는 방식이므로, `PostOrder` 방식으로 트리를 순회하여 문제를 해결할 수 있다.

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
    private int result;

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;

        findMaxPathSum(root);

        return result;
    }

    private int findMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftPathSum = Math.max(findMaxPathSum(root.left), 0);
        int rightPathSum = Math.max(findMaxPathSum(root.right), 0);

        result = Math.max(result, root.val + leftPathSum + rightPathSum);

        return root.val + Math.max(leftPathSum, rightPathSum);
    }
}
```

## Complexity
`n`은 트리의 노드 개수
- Time complexity: O(n)
- Space complexity: O(n)
