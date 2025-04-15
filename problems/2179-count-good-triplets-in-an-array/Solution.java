class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int[] idx1 = new int[n];

        for (int i = 0; i < n; i++) {
            idx1[nums1[i]] = i;
        }

        int[] idx2 = new int[n];
        for (int i = 0; i < n; i++) {
            idx2[i] = idx1[nums2[i]];
        }

        long result = 0;
        int[] tree = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int idx = idx2[i];

            int left = sum(idx - 1, tree);
            int right = n - 1 - idx - (i - left);

            result += (long) left * right;

            update(idx, tree);
        }

        return result;
    }

    private void update(int idx, int[] tree) {
        idx++;
        while (idx < tree.length) {
            tree[idx]++;
            idx += idx & -idx;
        }
    }

    private int sum(int idx, int[] tree) {
        idx++;
        int result = 0;

        while (idx > 0) {
            result += tree[idx];
            idx = idx & (idx - 1);
        }

        return result;
    }
}
