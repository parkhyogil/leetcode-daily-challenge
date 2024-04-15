# [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/description/)

## Intuition
BFS 기법을 이용해 트리의 레벨을 순차적으로 탐색한다.

## Algorithm
1. 노드를 저장할 `queue`를 선언.
2. `queue`에 `root`를 삽입하고 `queue`가 비어있지 않을 때까지 다음을 반복.    
2.1. `size`에 현재 레벨의 노드 개수를 저장.    
2.2. `queue`에서 `size`만큼 노드를 꺼내 `level`에 노드의 값을 저장하고, 자식이 null이 아니라면 `queue`에 삽입.   
2.3. `level`이 비어있지 않다면 `res`에 저장.
3. `res`를 리턴.

## Implementation
```java
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            while (size-- > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (!level.isEmpty()) {
                res.add(level);
            }
        }

        return res;
    }
}
```

## Complexity
- Time complexity: O(n)   
트리 전체를 한번 순회. `n`은 트리의 노드 개수. 

- Space complexity: O(n)   
`queue`에 최대 n/2 개의 노드가 들어갈 수 있다. `n`은 트리의 노드 개수.
