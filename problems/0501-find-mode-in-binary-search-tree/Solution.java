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
    private int currVal, currCount, maxCount;
    private List<Integer> list;

    public int[] findMode(TreeNode root) {
        currVal = 0;
        currCount = 0;
        maxCount = 0;
        list = new ArrayList<>();

        recur(root);

        return list.stream().mapToInt(i -> i).toArray();    
    }

    private void recur(TreeNode root) {
        if (root == null) {
            return;
        }

        recur(root.left);

        int val = root.val;

        if (val == currVal) {
            currCount++;
        } else {
            currVal = val;
            currCount = 1;
        }

        if (currCount > maxCount) {
            maxCount = currCount;
            list.clear();
        }

        if (currCount == maxCount) {
            list.add(val);
        }
        
        recur(root.right);
    }
}
