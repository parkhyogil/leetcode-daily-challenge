# [105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/)

## Intuition
Preorder 순회의 특징은 루트의 값이 먼저 나오고 그 뒤로 왼쪽 서브 트리, 오른쪽 서브 트리 순서로 값이 나온다.\
Inorder 순회의 특징은 왼쪽 서브 트리, 루트의 값, 오른쪽 서브 트리 순서로 값이 나온다.\
이 점을 이용해 `preorder`배열에서 첫 루트의 값을 찾고 `inorder`배열에서 루트의 값의 위치를 기준으로 왼쪽 부분은 루트의 왼쪽 서브 트리, 오른쪽 부분은 루트의 오른쪽 서브 트리로 만들 수 있다.\
Preorder 순회를 이용해 나눠진 `inorder`배열의 왼쪽 부분부터 재귀함수를 호출해 왼쪽 서브 트리를 완성하고 나머지 오른쪽 서브 트리를 완성해 전체 트리를 복구할 수 있다.


## Algorithm
1. `rootIdx`를 0으로 초기화한다. `rootIdx`는 `preorder` 배열에서 현재 루트 노드의 값을 가리킨다.
2. `inorderPos`에 Key로 노드의 값, Value로 `inorder`배열에서 노드의 값의 인덱스를 저장한다.
3. `left`를 `0`, `right`를 `inorder`배열의 마지막 인덱스 값으로 재귀함수를 호출한다.
   1. `left > right`일 경우 `null`을 리턴하며 재귀함수를 종료한다.
   2. 현재 노드의 값으로 `preorder[rootIdx]`를 선택하고 `rootIdx`를 1 증가 시킨다.
   3. `mid`에 `inorder`배열에서 현재 노드의 값의 위치를 저장한다.
   4. 먼저 `mid`를 기준으로 왼쪽 부분을 재귀함수를 호출해 왼쪽 서브 트리를 만들어 `node`의 왼쪽 노드에 저장한다.
   5. 나머지 오른쪽 부분을 재귀함수를 호출해 오른쪽 서브 트리를 만들어 `node`의 오른쪽 노드에 저장한다.
   6. `node`를 리턴하며 재귀함수를 종료한다.

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
    private int rootIdx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        rootIdx = 0;

        Map<Integer, Integer> inorderPos = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderPos.put(inorder[i], i);
        }

        return recur(0, inorder.length - 1, preorder, inorderPos);
    }

    private TreeNode recur(int left, int right, int[] preorder, Map<Integer, Integer> inorderPos) {
        if (left > right) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[rootIdx++]);

        int mid = inorderPos.get(node.val);

        node.left = recur(left, mid - 1, preorder, inorderPos);
        node.right = recur(mid + 1, right, preorder, inorderPos);

        return node;
    }
}
```

## Complexity
`n`은 노드의 개수
- Time complexity: O(n)\
`inorderPos`에 저장한 시간과 트리를 완성하기 위해 Preorder 순회에 사용한 시간.
- Space complexity: O(n)\
`inorderPos`와 콜스택에서 사용한 공간.
