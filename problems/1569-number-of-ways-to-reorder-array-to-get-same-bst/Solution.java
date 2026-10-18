class Solution {
    class Node {
        int val, count;
        Node left, right;

        Node(int v) {
            val = v;
            count = 1;
        }
    }

    Node root;
    long[][] comb;
    long mod = (long) 1e9 + 7;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        comb = new long[n + 1][n + 1];

        comb[1][0] = comb[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % mod;
            }
        }

        root = new Node(nums[0]);

        for (int i = 1; i < n; i++) {
            insert(root, nums[i]);
        }    

        return (int) ((dfs(root) - 1 + mod) % mod);
    }

    long dfs(Node node) {
        if (node == null) {
            return 1;
        }

        long l = dfs(node.left);
        long r = dfs(node.right);

        return (node.left == null ? 1 : comb[node.count - 1][node.left.count]) * l % mod * r % mod;
    }

    Node insert(Node node, int v) {
        if (node == null) {
            return new Node(v);
        }

        if (node.val > v) {
            node.left = insert(node.left, v);
        } else {
            node.right = insert(node.right, v);
        }

        node.count++;

        return node;
    }
}
