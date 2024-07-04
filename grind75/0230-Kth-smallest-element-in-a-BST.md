# [230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

## Intuition
이진 탐색 트리의 특징 중 하나는 Inorder 방식으로 트리를 순회하면 오름차순으로 정렬된 순서로 노드를 방문할 수 있다는 것이다. 
이를 이용해 리스트에 노드의 값을 삽입한 후, K번째 값을 찾을 수 있다.

## Algorithm
1. 트리 `root`를 Inorder 순회해서 리스트 `list`에 노드 값을 오름차순으로 삽입한다.
2. 리스트 `list`의 `k`번 째 값을 리턴한다.

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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        recur(root, list);

        return list.get(k - 1);
    }

    private void recur(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        recur(root.left, list);
        list.add(root.val);
        recur(root.right, list);
    }
}
```

## Complexity
`n`은 노드의 개수
- Time complexity: O(n)\
트리를 한 번 순회한다.
  
- Space complexity: O(n)\
리스트에 노드의 값을 저장한다.
