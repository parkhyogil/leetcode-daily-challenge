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
    public TreeNode reverseOddLevels(TreeNode root) {
        List<TreeNode> currLevel = new ArrayList<>();
        currLevel.add(root);

        int level = 0;

        while (!currLevel.isEmpty() && currLevel.get(0) != null) {
            List<TreeNode> nextLevel = new ArrayList<>();

            for (TreeNode node : currLevel) {
                nextLevel.add(node.left);
                nextLevel.add(node.right);
            }

            if (level % 2 == 1) {
                reverseNodeValues(currLevel);
            }

            currLevel = nextLevel;
            level++;
        }

        return root;
    }

    void reverseNodeValues(List<TreeNode> nodes) {
        int n = nodes.size();

        for (int i = 0; i < n / 2; i++) {
            int tmp = nodes.get(i).val;
            nodes.get(i).val = nodes.get(n - 1 - i).val;
            nodes.get(n - 1 - i).val = tmp;
        }
    }
}
