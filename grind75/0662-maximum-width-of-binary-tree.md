# [662. Maximum-Width-of-Binary-Tree](https://leetcode.com/problems/maximum-width-of-binary-tree/)

## Intuition
이진 트리의 특성을 이용한다.\
트리를 배열에서 표현할 때, 부모 노드가 인덱스 `i`일 때 왼쪽 자식 노드는 `i * 2`, 오른쪽 자식 노드는 `i * 2 + 1`가 된다.
배열에서 같은 레벨에 있는 노드끼리 모이게 되고, 레벨의 첫 번째 노드의 인덱스와 마지막 노드의 인덱스의 차이는 트리의 너비가 된다. 

## Algorithm
1. `int[] firstVal`에 레벨에서 첫 번째 노드의 인덱스를 저장한다.
2. 루트 노드에서 재귀 함수를 호출한다.
   1. 현재 노드가 `null`이라면 `0`을 리턴한다.
   2. 현재 레벨에 처음 방문하는 노드라면 `fisrtVal[depth]`에 `val`을 저장한다.
   3. 현재 노드의 값과 현재 레벨의 첫 노드의 값의 차이와 자식 노드에서 찾은 너비의 값 중 최댓값을 리턴한다.

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
    public int widthOfBinaryTree(TreeNode root) {
        int[] firstVal = new int[3001];

        return recur(0, 1, root, firstVal);
    }

    private int recur(int depth, int val, TreeNode root, int[] firstVal) {
        if (root == null) {
            return 0;
        }

        if (firstVal[depth] == 0) {
            firstVal[depth] = val;
        }

        return Math.max(val - firstVal[depth] + 1, Math.max(recur(depth + 1, val * 2, root.left, firstVal), recur(depth + 1, val * 2 + 1, root.right, firstVal)));
    }
}
```

## Complexity
`n`은 트리 노드 개수
- Time complexity: O(n) 
- Space complexity: O(n)
