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
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        return recur(n, new List[n + 1]);
    }

    private List<TreeNode> recur(int n, List<TreeNode>[] memo) {
        if (n == 1) {
            return List.of(new TreeNode());
        }

        if (memo[n] != null) {
            return memo[n];
        }

        List<TreeNode> res = new ArrayList<>();
        int left = 1;
        int right = n - 2;
        
        while (left < n) {
            for (TreeNode leftNode : recur(left, memo)) {
                for (TreeNode rightNode : recur(right, memo)) {
                    TreeNode node = new TreeNode();
                    node.left = leftNode;
                    node.right = rightNode;
                    res.add(node);
                }
            }
            left += 2;
            right -= 2;
        }
        return res;
    }
}
