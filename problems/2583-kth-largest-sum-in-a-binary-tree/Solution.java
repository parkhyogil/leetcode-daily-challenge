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
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> levelSums = new ArrayList<>();

        inorderTraversal(0, root, levelSums);

        if (k > levelSums.size()) {
            return -1;
        }

        return quickSelect(k - 1, levelSums);
    }

    long quickSelect(int k, List<Long> nums) {
        int lo = 0;
        int hi = nums.size() - 1;

        while (lo <= hi) {
            int partitionIndex = partition(lo, hi, k, nums);

            if (k == partitionIndex) {
                return nums.get(k);
            } else if (k < partitionIndex) {
                hi = partitionIndex - 1;
            } else {
                lo = partitionIndex + 1;
            }
        }
        return -1;
    }

    int partition(int lo, int hi, int k, List<Long> nums) {
        int mid = (lo + hi) / 2;
        long pivotValue = nums.get(mid);

        swap(hi, mid, nums);

        int i = lo;
        int j = hi - 1;

        while (i <= j) {
            while (i < hi && nums.get(i) > pivotValue) {
                i++;
            }
            while (lo <= j && nums.get(j) < pivotValue) {
                j--;
            }

            if (i < j) {
                swap(i++, j--, nums);
            } else {
                j--;
            }
        }

        swap(i, hi, nums);
        return i;
    }

    void swap(int i, int j, List<Long> nums) {
        long tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }

    void inorderTraversal(int level, TreeNode root, List<Long> levelSums) {
        if (root == null) {
            return;
        }

        if (levelSums.size() == level) {
            levelSums.add((long) root.val);
        } else {
            levelSums.set(level, root.val + levelSums.get(level));
        }

        inorderTraversal(level + 1, root.left, levelSums);
        inorderTraversal(level + 1, root.right, levelSums);
    }
}
