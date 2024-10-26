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
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] nodeHeightMap = new int[100001];
        int[] nodeLevelMap = new int[100001];
        List<int[]> twoMaxHeightNodesOfLevel = new ArrayList<>();

        dfs(0, root, nodeHeightMap, nodeLevelMap, twoMaxHeightNodesOfLevel);

        int m = queries.length;
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            result[i] = getMaxHeightAfterRemoveNode(queries[i], nodeHeightMap, nodeLevelMap, twoMaxHeightNodesOfLevel);
        }

        return result;
    }

    private int dfs(int level, TreeNode root, int[] nodeHeightMap, int[] nodeLevelMap, List<int[]> twoMaxHeightNodesOfLevel) {
        if (root == null) {
            return -1;
        }

        if (twoMaxHeightNodesOfLevel.size() == level) {
            twoMaxHeightNodesOfLevel.add(new int[2]);
        }

        int subtreeHeight = 1 + Math.max(dfs(level + 1, root.left, nodeHeightMap, nodeLevelMap, twoMaxHeightNodesOfLevel),
                dfs(level + 1, root.right, nodeHeightMap, nodeLevelMap, twoMaxHeightNodesOfLevel));

        nodeHeightMap[root.val] = subtreeHeight;
        nodeLevelMap[root.val] = level;

        updateTwoMaxHeightNodes(root.val, nodeHeightMap, twoMaxHeightNodesOfLevel.get(level));

        return subtreeHeight;
    }

    private void updateTwoMaxHeightNodes(int node, int[] nodeHeightMap, int[] twoMaxHeightNodes) {
        int maxNode0 = twoMaxHeightNodes[0];
        int maxNode1 = twoMaxHeightNodes[1];

        if (maxNode0 == 0 || nodeHeightMap[node] > nodeHeightMap[maxNode0]) {
            twoMaxHeightNodes[0] = node;
            twoMaxHeightNodes[1] = maxNode0;
        } else if (maxNode1 == 0 || nodeHeightMap[node] > nodeHeightMap[maxNode1]) {
            twoMaxHeightNodes[1] = node;
        }
    }

    private int getMaxHeightAfterRemoveNode(int targetNode, int[] nodeHeightMap, int[] nodeLevelMap, List<int[]> twoMaxHeightNodesOfLevel) {
        int maxHeight = -1;

        for (int node : twoMaxHeightNodesOfLevel.get(nodeLevelMap[targetNode])) {
            if (node != 0 && node != targetNode) {
                maxHeight = Math.max(maxHeight, nodeHeightMap[node]);
            }
        }

        return maxHeight + nodeLevelMap[targetNode];
    }
}
