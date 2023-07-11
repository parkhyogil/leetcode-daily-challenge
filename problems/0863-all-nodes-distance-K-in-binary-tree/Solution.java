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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, TreeNode> parent = getParent(root);

        List<Integer> res = new ArrayList<>();
        recur(target, -1, k, parent, res);
        return res;
    }

    private void recur(TreeNode node, int prev, int k, Map<Integer, TreeNode> parent, List<Integer> res) {
        if (k == 0) {
            res.add(node.val);
            return;
        }

        if (node.left != null && node.left.val != prev) {
            recur(node.left, node.val, k - 1, parent, res);
        }
        if (node.right != null && node.right.val != prev) {
            recur(node.right, node.val, k - 1, parent, res);
        }
        if (parent.containsKey(node.val) && parent.get(node.val).val != prev) {
            recur(parent.get(node.val), node.val, k - 1, parent, res);
        }
    }

    private Map<Integer, TreeNode> getParent(TreeNode root) {
        Map<Integer, TreeNode> res = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                res.put(node.left.val, node);
                q.offer(node.left);
            }
            if (node.right != null) {
                res.put(node.right.val, node);
                q.offer(node.right);
            }
        }

        return res;
    }
}
