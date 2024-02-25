class Solution {
    private int[] root;

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return true;
        }

        root = new int[100001];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }

        for (int num : nums) {
            if (num == 1) {
                return false;
            }

            for (int i = 2; i * i <= num; i++) {
                if (num % i != 0) {
                    continue;
                }

                union(i, num);
                union(num / i, num);
            }
        }

        for (int i = 0; i < n; i++) {
            if (findRoot(nums[i]) != findRoot(nums[0])) {
                return false;
            }
        }

        return true;
    }

    private int findRoot(int child) {
        if (child == root[child]) {
            return child;
        }
        return root[child] = findRoot(root[child]);
    }

    private void union(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);

        if (a < b) {
            root[b] = a;
        } else {
            root[a] = b;
        }
    }
}
