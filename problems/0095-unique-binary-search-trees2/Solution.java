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
    public List<TreeNode> generateTrees(int n) {
        return recur(1, n, new HashMap<>());
    }

    private List<TreeNode> recur(int lo, int hi, Map<Integer, Map<Integer, List<TreeNode>>> memo) {
        if (memo.containsKey(lo) && memo.get(lo).containsKey(hi)) {
            return memo.get(lo).get(hi);
        }

        List<TreeNode> res = new ArrayList<>();
        if (lo > hi) {
            res.add(null);
            return res;             
        }

        for (int val = lo; val <= hi; val++) {
            for (TreeNode left : recur(lo, val - 1, memo)) {
                for (TreeNode right : recur(val + 1, hi, memo)) {
                    res.add(new TreeNode(val, left, right));
                }
            }
        }

        memo.computeIfAbsent(lo, k -> new HashMap<>()).put(hi, res);
        return res;
    }
}
