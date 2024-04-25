# [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/)

## Intuition
주어진 두개의 노드에서부터 루트까지의 경로를 비교해 답을 찾을 수 있다.

## Algorithm
1. `pPath`, `qPath`에 `p`에서 루트, `q`에서 루트까지의 경로를 저장한다.
   1. 타겟 노드에서부터 루트까지의 경로를 구하기 위해 `findPath()`를 선언.
   2. `root`가 null이라면 false 리턴.
   3. `root`가 `target`과 같다면 `path`에 노드를 저장하고 true 리턴.
   4. 양쪽의 서브트리에서 타겟을 찾아 true를 리턴했다면 해당 노드는 루트에 포함되기 때문에 `path`에 저장하고 true를 리턴.
   5. 서브트리에서 타겟노드를 찾지 못했다면 false 리턴.
2. `i`, `j`에 각 경로의 마지막 인데스를 저장한다.
3. `pPath`의 `i`번째 노드와 `qPath`의 `j`번째 노드가 다를 때까지 `i`와 `j`를 줄인다.
4. 달라지기 직전의 노드를 결과로 리턴.

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();

        findPath(root, p, pPath);
        findPath(root, q, qPath);

        int i = pPath.size() - 1;
        int j = qPath.size() - 1;

        while (i >= 0 && j >= 0 && pPath.get(i) == qPath.get(j)) {
            i--;
            j--;
        }
        return pPath.get(i + 1);
    }

    private boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return false;
        }

        if (root.val == target.val) {
            path.add(root);
            return true;
        }

        if (findPath(root.left, target, path) || findPath(root.right, target, path)) {
            path.add(root);
            return true;
        }

        return false;
    }
}
```

## Complexity
`n`은 트리 노드의 개수.
- Time complexity: O(n)\
경로를 찾기 위해 트리 전체를 순회하고 경로를 비교한 시간.
- Space complexity: O(n)\
재귀함수의 콜스택과 경로 저장에 사용한 공간.
