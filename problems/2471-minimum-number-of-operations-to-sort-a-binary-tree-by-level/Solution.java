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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int numOfOperations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            int[] values = new int[size];
            int i = 0;

            while (size-- > 0) {
                TreeNode node = queue.poll();
                values[i++] = node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            numOfOperations += getNumOfOperationsToSortList(values);
        }

        return numOfOperations;
    }

    int getNumOfOperationsToSortList(int[] values) {
        int n = values.length;

        int[] sortedValues = values.clone();
        Arrays.sort(sortedValues);

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            indexMap.put(sortedValues[i], i);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            while (values[i] != sortedValues[i]) {
                int j = indexMap.get(values[i]);
                
                int tmp = values[i];
                values[i] = values[j];
                values[j] = tmp;
                result++;
            }
        }

        return result;
    }
}
