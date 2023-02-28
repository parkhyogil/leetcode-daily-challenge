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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        dfs(root, res, new HashMap<>());
        return res;
    }

    private String dfs(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
        if (root == null) {
            return "";
        }
        String key = root.val + "L" + dfs(root.left, res, map) + "R" + dfs(root.right, res, map);
        
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
            if (map.get(key) == 2) {
                res.add(root);
            }
        } else {
            map.put(key, 1);
        }
        return key;
    }
}
