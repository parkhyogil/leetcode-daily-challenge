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
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();

            LinkedList<Integer> list = new LinkedList<>();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node == null) {
                    continue;
                }

                if (res.size() % 2 == 0) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                
                q.offer(node.left);
                q.offer(node.right);
            }
            if (!list.isEmpty()) {
                res.add(list);
            }
        }
        return res;
    }
}
