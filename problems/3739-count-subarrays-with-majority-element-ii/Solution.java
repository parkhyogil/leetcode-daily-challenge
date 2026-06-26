class Solution {
    int[] tree;

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        tree = new int[n * 2 + 2];

        long result = 0;
        int x = 0;

        update(n + 1);

        for (int i = 0; i < n; i++) {
            x += nums[i] == target ? 1 : -1;

            result += query(x + n);

            update(x + n + 1);
        }

        return result;
    }

    void update(int i) {
        while (i < tree.length) {
            tree[i]++;

            i += i & -i;
        }
    }

    int query(int i) {
        int result = 0;

        while (i > 0) {
            result += tree[i];

            i -= i & -i;
        }

        return result;
    }
}
